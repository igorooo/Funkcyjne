class Pracownik(val nazwisko: String) {
  private var zwolniony: Boolean = false
  Pracownik.liczbaZatrudnionych += 1

  def zwolnij { Pracownik.liczbaZatrudnionych -= 1; zwolniony = true }
  override def toString = nazwisko + " " + (if (zwolniony) "zwolniony" else "zatrudniony")
}
object Pracownik {
  private var liczbaZatrudnionych: Int = 0
  def liczbaPracowników = liczbaZatrudnionych
}

object Company extends App {
  val pracownik = new Pracownik("Tomek")
  println(pracownik) // Tomek zatrudniony
  println(Pracownik.liczbaPracowników) // 1
  pracownik.zwolnij
  println(pracownik) // Tomek zwolniony
  println(Pracownik.liczbaPracowników) // 0
}