
class Time(private var hour: Int, private var minute: Int) {
  require( 0 <= hour && hour < 24, "hour= "+hour)
  require( 0 <= minute && minute < 60, "minute = "+minute)


}

object test{

  def main(args: Array[String]): Unit = {

   // var tim1 = new Time(0,2)
    //var tim = new Time(1,59)

  }
}
