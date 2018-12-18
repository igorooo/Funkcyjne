
/** ZAD 2a */
class Time(private var hour: Int, private var minute: Int) {
  require( 0 <= hour && hour < 24, "hour= "+hour)
  require( 0 <= minute && minute < 60, "minute = "+minute)

  def h:(Int) = hour

  def h_=(newHour:Int): Unit ={
    require( 0 <= newHour && newHour < 24, "newHour= "+newHour)
    hour = newHour
  }

  def m:(Int) = minute

  def m_=(newMinute:Int): Unit ={
    require(0 <= newMinute && newMinute < 60,"newMinute= "+newMinute)
    minute = newMinute
  }

  def before(other: Time):Boolean = {

    if(other.h > this.h) true
    else if(other.h < this.h ) false
    else {
      if(other.m > this.m) true
      else false
    }
  }


}

/** ZAD 2b */
class Time2(hour: Int,minute: Int) {
  require( 0 <= hour && hour < 24, "hour= "+hour)
  require( 0 <= minute && minute < 60, "minute = "+minute)

  private var time:Int = minute + hour*60


  def h:(Int) = time / 60

  def h_=(newHour:Int): Unit ={
    require( 0 <= newHour && newHour < 24, "newHour= "+newHour)
    time = (time % 60) + newHour * 60
  }

  def m:(Int) = time % 60

  def m_=(newMinute:Int): Unit ={
    require(0 <= newMinute && newMinute < 60,"newMinute= "+newMinute)
    time = time - (time % 60) + newMinute
  }

  def before(other: Time2):Boolean = this.time < other.time

}

/** ZAD 3 */

class Pojazd(private val Producent: String, private val Model: String, private val PYear: Int = -1, private var CarNumber: String = "") {



}


object test{

  def main(args: Array[String]): Unit = {


    var tim = new Time(2,20)
    var tim1 = new Time(1,2)
    var tim2 = new Time(1,59)

    println(tim.h + " " + tim.m)

    println(tim1.before(tim))
    println(tim.before(tim1))
    println(tim.before(tim))
    println(tim1.before(tim2))

    println("\nTime2 \n")

    var t = new Time2(2,20)
    var t1 = new Time2(1,2)
    var t2 = new Time2(1,59)

    println(t.h + " " + t.m)

    t.h = 4
    t.m = 40

    println(t.h + " " + t.m)

    println(" ZAD 3")



  }
}
