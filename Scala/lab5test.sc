val n = List(1,2,3,4,5)

def moveRound[A](iter:Int,end:Int,xs:List[A],res:List[A],pattern:List[A]):List[A] = {
  if(iter == end) res.reverse
  else{
    xs.tail match {
      case Nil => moveRound(iter+1,end,pattern,xs.head::res,pattern)
      case _ => moveRound(iter+1,end,xs.tail,xs.head::res,pattern)
    }
  }
}
//moveRound(begin, begin, moveIter(0, n),List())
moveRound(2, 1, List(3,4,5),List(),List(1,2,3,4,5))



