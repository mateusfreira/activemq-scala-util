[![Build Status](https://travis-ci.org/mateusfreira/activemq-scala-util.svg?branch=master)](https://travis-ci.org/mateusfreira/activemq-scala-util)

A simple way to use ActiveMQ queues in scala projects

# How to use!
Create a manaer sample
```scala
    val manager = QueueManager("tcp://localhost:61616")//you need to change tcp://localhost:61616 by you activeMe server url.
```
Create a object to be enqueue and dequeue objects

```scala
    object StrQueue extends Queue[String/** here you put some Serializable class(can be a case class)*/]{
        override val queueName = "srtint_queue"//Provice you queue name
        def dequeeue(n:String){
            ...// here you do something
        }
    }
    //start the queue
    StrQueue.start(manager)//Now you are ready to use your queue
    //to queue call the method queue...
    StrQueue.queue(obj)
```

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

##Helpful links
[ActiveMQ instalation guide](http://activemq.apache.org/installation.html)
