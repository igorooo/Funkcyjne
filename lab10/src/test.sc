

class SQueue[+T] (val queue: (List[T],List[T]))  {

  def enqueue[S>:T](e : S):SQueue[S] = {
    match queue {
      case (Nil,Nil) =>new SQueue[S]((List(e),Nil))
      case (Nil, l2) => new SQueue[S]((Nil, (e::l2) ))
    }
  }

}

val s = "e"
val f = List("a","b")

s::f

