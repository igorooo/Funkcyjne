

class Time(var hour: Int){
  if(hour < 0) hour = 0

  def time: Int = hour

  def time_= (newHour :  Int){
    if(newHour < 0) hour = 0
    else hour = newHour
  }

}

object Time{
  def apply(h :Int = 0) = new Time(h)
}

var tim1 = new Time(5)
var tim = Time(3)

tim.hour
tim.time = 1
tim.time
tim.time = -1
tim.time




