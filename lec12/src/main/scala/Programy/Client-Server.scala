import akka.actor._

class Server extends Actor {
  private var counter = 0
  def receive = {
      case Server.M(msg) => { counter += 1
                              sender ! Client.R("counter = "+counter)
                            } 
      case   msg         => sender ! s"Wrong request: '$msg'"
  }
}
object Server {
  def props = Props[Server] 
  case class M(msg: String)  
}

class Client(server: ActorRef) extends Actor {
  def receive = {
     case Client.Start   => server ! Server.M("counter?")  
                            server ! Server.M("counter?") 
                            server ! "counter?"   
     case Client.R(response) => println(response)
     case  other             => println(other) 
  }    
} 
object Client {
  def props = Props(classOf[Client], Main.server)
  case class R(response: String)
  case object Start 
}

object Main extends App {
    val ourSystem = ActorSystem("MyActorSystem")
    val server: ActorRef = ourSystem.actorOf(Server.props, "MyServer")
    val client: ActorRef = ourSystem.actorOf(Client.props)
    client ! Client.Start
	server.tell(Server.M("Answer to the client"), client)

    import scala.concurrent.duration._
    implicit val timeout = akka.util.Timeout(5.seconds)
    import ourSystem.dispatcher
    import akka.pattern.ask
    val responseFuture = server ? Server.M("counter?")
    responseFuture foreach {
      case Client.R(response) => 
         println("Handling response using future: " + response)
    }
	Thread.sleep(1000)
	ourSystem.terminate
}


