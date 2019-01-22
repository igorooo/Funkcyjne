import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class Greeter(name: String) extends Actor {
  def receive = {
    case "hello" => println("Hello World! from "+name)
    case    _    => println("What? said "+name)       
  }
}

object Main extends App {
// ActorSystem is a heavy object: create only one per application
  val ourSystem = ActorSystem()
  val greeter: ActorRef = ourSystem.actorOf(Props(classOf[Greeter],"John")) // recommended, but has limitations
//  val greeter = ourSystem.actorOf(Props(new Greeter("John"))) // do not use within actors
  greeter ! "hello"
  greeter ! "witaj"   

Thread.sleep(1000)
ourSystem.terminate
}