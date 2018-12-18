
class Time(private var hour: Int, private var minute: Int) {
  require( 0 <= hour && hour < 24, "hour= "+hour)
  require( 0 <= minute && minute < 60, "minute = "+minute)


}

var tim1 = new Time(0,2)



try{
  var tim = new Time(1,59)
}

catch {
  case e: IllegalArgumentException => println("IllegalArgument")
  case _: Throwable => println("whatever")
}

