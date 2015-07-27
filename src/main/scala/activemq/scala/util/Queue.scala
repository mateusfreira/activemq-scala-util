package activemq
package scala
package util

import org.apache.activemq.ActiveMQConnectionFactory

import javax.jms._
trait Queue[T <: java.io.Serializable] extends MessageListener {
    val queueName:String
    protected var boxManager:Option[QueueManager] = None
    def manager:QueueManager = boxManager match {
        case Some(m) => m
        case _ => throw new RuntimeException("Manager not found!")
    }
    lazy val destination = manager.session.createQueue(queueName)
    def queue(obj:T){
        val producer = manager.session.createProducer(destination)
        producer.send(manager.session.createObjectMessage(obj))
    }
    def dequeeue(obj:T)

    def onMessage(message:Message):Unit = {
        if (message.isInstanceOf[ObjectMessage]) {
            val objMessage = message.asInstanceOf[ObjectMessage]
            val obj = objMessage.getObject().asInstanceOf[T]
            dequeeue(obj)
        } else {
            throw new RuntimeException(" Oops, %s recive one message not a object message".format(queueName))
        }
    }
    def start(manager:QueueManager) {
        boxManager = Some(manager)
        lazy val consumer = manager.session.createConsumer(destination)
        consumer.setMessageListener(this)        
    }

 }