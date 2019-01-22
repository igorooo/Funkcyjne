package Programy

import akka.actor.{Actor, ActorRef, ActorSystem, Props, ActorLogging}

class Greeter(name: String, Hello: Greeter.M) extends Actor with ActorLogging {
  def receive = {
    case Hello => log.info(s"Hello World! from $name")      
  }
  override def unhandled(msg: Any) =
    msg match {
	  case msg: String => log.info(s"Unexpected message '$msg'")
	  case msg         => super.unhandled(msg)
	}  
}

object Greeter {
  def props = Props(classOf[Greeter],"John", M("witaj"))
  case class M(hello: String)
}

object Main extends App {
  val ourSystem = ActorSystem()
  val greeter: ActorRef = ourSystem.actorOf(Greeter.props) 
  greeter ! Greeter.M("witaj") // takie komunikaty są obsługiwane przez naszego aktora
  greeter ! "hello"            // będziemy wyświetlać nieoczekiwane komunikaty napisowe (metoda unhandled)
  greeter ! Greeter.M("hello") // zostanie przekazany do strumienia zdarzeń systemu aktorów (metoda unhandled)

  Thread.sleep(1000)
  ourSystem.terminate
}