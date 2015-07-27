package activemq
package scala
package util

import org.apache.activemq.ActiveMQConnectionFactory

import javax.jms._
case class QueueManager(brokerUrl:String){
    lazy val factory:ConnectionFactory = new ActiveMQConnectionFactory(brokerUrl)
    val connection = factory.createConnection()
    connection.start()
    lazy val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
}