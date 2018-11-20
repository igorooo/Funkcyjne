def moveRight[A](offset:Int, n:List[A]):List[A] = {

  val begin =n.length - (offset % n.length)
  def moveR(iter:Int,xs:List[A],res:List[A]):List[A] = {
    if( iter < begin ) moveR(iter+1, xs.tail, xs.head :: res) else xs:::(res.reverse)
  }
  moveR(0,n,List())
}

moveRight(1,List(1,2,3,4,5))
moveRight(0,List(1,2,3,4,5))
moveRight(3,List(1,2,3,4,5))
moveRight(8,List(1,2,3,4,5))
moveRight(1,List('a','b','c','d'))