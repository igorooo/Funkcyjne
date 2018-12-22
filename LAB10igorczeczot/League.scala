trait League[A <: Game] {

  def presentation() : Unit
  def prepare_schedule() : Unit
  def winner(TEAM_A : Team[A], TEAM_B : Team[A]) : Team[A]

}
