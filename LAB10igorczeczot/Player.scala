class Player(val NAME : String, val NATIONALITY : String, var NUMBER: Int) {

  def show(): Unit = println(NAME + " " + NATIONALITY + " " + NUMBER)
}
