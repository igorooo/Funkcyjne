class SportGame(val NAME_ : String, val RULES : String, val N_OF_TEAMS : Int, val N_OF_PLAYERS : Int) extends Game {
  override def rules(): String = "\n"  + NAME + "game:\nRules: "+RULES+"\nGame for "+N_OF_TEAMS + " teams "+N_OF_PLAYERS + " players each\n"

  override def NAME: String = NAME_
}
