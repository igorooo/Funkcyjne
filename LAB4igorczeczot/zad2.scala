
//tailrecursion
def sumTl(a:List[String], b:List[String]):List[String] = {
  def sumtl(a:List[String],b:List[String],c:List[String]):List[String] = (a,b) match{
    case (Nil, Nil) => c
    case (Nil, _) => sumtl(Nil,b.tail, c :+ b.head )
    case (_, Nil) => sumtl(a.tail,Nil, c :+ a.head )
    case (_,_) => sumtl(a.tail,b.tail, c :+ (a.head + b.head) )
  }
  sumtl(a,b,List())
}

sumTl(List("a","b","c","d"),List("e","f","g","h","i","j"))
sumTl(List(), List("1","2","3"))
sumTl(List(),List())
sumTl(List("A","B"),List("a","b"))

//resursion
def suma(a:List[String], b:List[String]):List[String] = (a,b) match{
  case (Nil, Nil) => List()
  case (Nil, _) => b.head :: suma(Nil,b.tail)
  case (_, Nil) => a.head :: suma(a.tail, Nil)
  case (_,_) => ( a.head + b.head ) :: suma(a.tail,b.tail)
}


suma(List("a","b","c","d"),List("e","f","g","h","i","j"))
suma(List(), List("1","2","3"))
suma(List(),List())
suma(List("A","B"),List("a","b"))

