import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class SwapActor extends Actor {
  def sad: Receive = {
    case "beSad"   => println("I'm already sad :-(")
    case "beHappy" => {println("I'm becoming happy"); context.become(happy)}
  }

  def happy: Receive = {
    case "beHappy" => println("I'm already happy :-)")
    case "beSad"   => {println("I'm becoming sad"); context.become(sad)}
  }

  def receive = happy
}
	
object Main extends App {
  val ourSystem = ActorSystem()
  val swapActor: ActorRef = ourSystem.actorOf(Props(classOf[SwapActor])) 
  swapActor ! "beHappy"
  swapActor ! "beSad"  
  swapActor ! "beSad" 
  swapActor ! "beHappy"

  Thread.sleep(1000)
  ourSystem.terminate
}
	