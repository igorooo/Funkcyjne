import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class Greeter extends Actor {
  def receive = {
    case "hello"   => println("Hello World!")
    case  msg      => println(s"Unexpected message '$msg'")         
  }
}

object Main extends App {
   // ActorSystem is a heavy object: create only one per application
    val ourSystem = ActorSystem("MySystem")
    val greeter: ActorRef = ourSystem.actorOf(Props[Greeter])
    greeter ! "hello"
    greeter ! "witaj"   
    greeter ! "hello"

    Thread.sleep(1000)
    ourSystem.terminate
}