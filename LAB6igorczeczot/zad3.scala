
def stream (n:Int):Stream[Int] = {
  def pow(a:Int,b:Int):Int = {
    def poww(i:Int):Int = if(i < b) a*poww(i+1) else 1
    poww(0)
  }
  Stream.from(0).map((x:Int) => pow(n,x))
}

stream(5).take(10).toList
stream(4).take(10).toList
stream(3).take(10).toList

