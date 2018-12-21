class Team[A <: Game](val NAME : String, var N_OF_PLAYERS : Int, var PLAYERS : List[Player], GAME : A) {

  def presentation(): Unit = {
    println("We are " + NAME + "\nWe play " + GAME.name + "\nWe are team of " + N_OF_PLAYERS + ":\n")

  }

  def show_players(): Unit = {
    for( x <- PLAYERS ) x.show()
  }

}
