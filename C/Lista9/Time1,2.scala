/* Zadanie 1 */
class Time(var hour: Int) {
  if (hour < 0) hour = 0
}

/* Zadanie 2 */
object Time {	// ten sam plik & ta sama nazwa & istniejąca klasa => obiekt towarzyszący
  def apply(hour: Int) = new Time(hour)
}