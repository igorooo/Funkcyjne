/* Zadanie 1 */
class Time(var hour: Int) {
  if (hour < 0) hour = 0
}

/* Zadanie 2 */
object Time {	// ten sam plik & ta sama nazwa & istniej¹ca klasa => obiekt towarzysz¹cy
  def apply(hour: Int) = new Time(hour)
}