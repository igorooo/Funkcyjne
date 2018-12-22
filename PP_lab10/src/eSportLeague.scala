import scala.util.Random

class eSportLeague(val NAME_ : String, val SYSTEM : String, val N_OF_TEAMS : Int, val TEAMS : List[Team[eSPORTGAME]], val GAME : eSPORTGAME) extends League [eSPORTGAME ]{
  override def presentation(): Unit = {
    println("-------LEAGUE PRESENTATION--------")
    println("\nLeague: " + NAME_ + "\nleague of :\n" + GAME.rules() + "\n\ngame in "+ SYSTEM + " system\n" + "league contains "+N_OF_TEAMS + " teams:\n")
    for(x <- TEAMS){
      x.presentation()
    }
    println("-------END OF PRESENTATION--------")
  }

  var RAND : Random = new Random()

  override def prepare_schedule(): Unit = {
    def funct( TEAMS_ : List[Team[eSPORTGAME]] ): Unit ={
      TEAMS_ match {
        case Nil => println("-----")
        case hd::Nil => println(hd.NAME + " waiting for opponent\n-----")
        case hd::tl => println(hd.NAME + " vs " + tl.reverse.head.NAME); funct(tl.reverse.tail)
      }
    }
    println("\nSchedule:")
    funct(TEAMS)
  }

  override def winner(TEAM_A : Team[eSPORTGAME], TEAM_B : Team[eSPORTGAME]): Team[eSPORTGAME] = {
    if(RAND.nextInt() % 2 == 0) TEAM_A else TEAM_B
  }

}
