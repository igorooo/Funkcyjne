import Player.Ball
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, PoisonPill, Props}

import scala.util.Random

class Player(val NUM : Int, val PLAYERS : Array[ActorRef]) extends Actor {
  val RAND = new Random()
  val AR_LEN = PLAYERS.length

  def next_target(): ActorRef = {
    var NEXT_N = Math.abs(RAND.nextInt()) % AR_LEN
    while(NEXT_N == NUM){
      NEXT_N = Math.abs(RAND.nextInt()) % AR_LEN
    }
   // println(s"NextN $NEXT_N")
    PLAYERS(NEXT_N)
  }

  override def receive: Receive = {

    case Ball(count) => {
      Thread.sleep(700)
      println(s"Player no. $NUM received ball, makes a throw no. ${count+1} ")
      next_target() ! Player.Ball(count+1)

    }

    case msg =>{
      println(s"Unexpected message $msg")
    }
  }
}

object Player{
  def props(N : Int, ARRAY : Array[ActorRef]) = Props(classOf[Player],N,ARRAY)
  case class Ball(COUNTER : Int)
}

object Main extends App{

  val ourSystem = ActorSystem()

  var PLAYERS_ARRAY = new Array[ActorRef](3)

  for(i <- 0 to 2){
    PLAYERS_ARRAY(i) =  ourSystem.actorOf(Player.props(i,PLAYERS_ARRAY))
  }

  PLAYERS_ARRAY(0) ! Player.Ball(0)


  //Thread.sleep(1000)
  //ourSystem.terminate()
}


