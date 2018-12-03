import scala.actors.Actor._
import scala.actors.Actor

object ClientServer {

	def main(args: Array[String]) {
		var clientArray = new Array[Actor](10)
		for (i <- 1 to 9) clientArray(i) = new SyncClient(i, SyncServer)
		for (i <- 1 to 9) clientArray(i).start

		clientArray = new Array[Actor](10)
		for (i <- 1 to 9) clientArray(i) = new AsyncClient(i, AsyncServer)
		for (i <- 1 to 9) clientArray(i).start
	}

	val SyncServer = actor {
		var queryCounter = 0
		loop {
			react {
				case query =>
					queryCounter += 1
					println("Received message: " + query)
					reply("Current query counter: " + queryCounter)
			}
		}
	}

	class SyncClient(id: Int, server: Actor) extends Actor {
		override def act {
			val response = server !? "Here is client of ID: " + id
			println("Client of ID: " + id + " received response: " + response)
		}
	}

	val AsyncServer = actor {
		var queryCounter = 0
		loop {
			react {
				case query =>
					queryCounter += 1
					println("Received message: " + query)
					sender ! "Current query counter is " + queryCounter
			}
		}
	}

	class AsyncClient(id: Int, server: Actor) extends Actor {
		override def act {
			server ! "Here is client of ID: " + id
			println("Client of ID " + id + " received response: " + ?)
		}
	}
}