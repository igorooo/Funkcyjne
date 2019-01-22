import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, PoisonPill, Props}

class Player(var COUNTER : Int = 20) extends Actor {
  def decrease()= COUNTER -= 1

  def check_counter():Boolean = {
    if(COUNTER > 0){
      return true;
    }

    else{
      sender() ! PoisonPill
      self ! PoisonPill
      return false;
    }
  }

  override def receive: Receive = {

    case player : ActorRef => {
      println("Starting match!")

      if(check_counter()){
        decrease()
        player ! Player.Shout("Ping")
      }
    }

    case Player.Shout("Pong")=> {
      println("Received: Pong")

      if(check_counter()){
        decrease()
        sender() ! Player.Shout("Ping")
      }
    }

    case Player.Shout("Ping")=>{
      println("Received: Ping")

      if(check_counter()){
        decrease()
        sender() ! Player.Shout("Pong")
      }
    }

    case msg =>{
      println(s"Unexpected message $msg")
    }
  }
}

object Player{
  def props(N : Int) = Props(classOf[Player],N)
  case class Shout(MSG : String)
}

object Main extends App{

  val HITS : Int = 10

  val ourSystem = ActorSystem()
  val PLAYER_1 : ActorRef = ourSystem.actorOf(Player.props(HITS))
  val PLAYER_2 : ActorRef = ourSystem.actorOf(Player.props(HITS))

  PLAYER_1 ! PLAYER_2

  //PLAYER_1.tell(Player.Shout("Ping"),PLAYER_2)

  Thread.sleep(1000)
  ourSystem.terminate()
}


