trait Game {

  def rules() : String
  def run(TEAMS : Team[Any]*) : Team[Any]
  def NAME : String



}
