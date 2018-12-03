class Time(time: String) {		// time jako zwyk³y argument, bo nie przechowujemy w klasie
  val t = time.split(":")
  val hour = t(0).toInt
  val minute = t(1).toInt
}