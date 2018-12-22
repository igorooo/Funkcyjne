class Team[A <: Game](val NAME : String, var N_OF_PLAYERS : Int, var PLAYERS : List[Player], GAME : A) {

  def presentation(): Unit = {
    println("\nWe are " + NAME + "\nWe play " + GAME.NAME + "\nWe are team of " + N_OF_PLAYERS + ":\n")
    show_players()

  }

  def show_players(): Unit = {
    for( x <- PLAYERS ) x.show()
  }

}
