package activemq.scala.util.specs

import org.specs2.mutable._
import org.specs2.execute.Pending
import activemq.scala.util._

class QueueSpec extends Specification {

	"When using a queeue" should {

		"Create a QueueManager without problems" in {
			val m = QueueManager("vm://localhost?broker.persistent=false")
			m must not beNull
		}
		"Queue a message without problems" in {
			val m = QueueManager("vm://localhost?broker.persistent=false")
			object StrQueue extends Queue[String]{
			    override val queueName = "srtint_queue"
			    def dequeeue(n:String){
			    	m must beEqualTo("Yep!") 
			    }
			}
			StrQueue.start(m)
			StrQueue.queue("Yep!")
		}


	}
}