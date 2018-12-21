class EmptyQueueException extends Exception

class SQueue[+T] private (private val queue: (List[T],List[T]))  {
  def this() = this((Nil,Nil))

  def enqueue[S>:T](e : S):SQueue[S] = {
    queue match {
      case (Nil,Nil) =>new SQueue[S]((List(e),Nil))
      case (Nil, l2) => new SQueue[S](( (e::l2).reverse, Nil ))
      case (l1,l2) => new SQueue[S]((l1,e::l2))
    }
  }

  def dequeue():SQueue[T] = {
    queue match {
      case (Nil,Nil) => new SQueue[T](Nil, Nil)
      case (Nil, l2) => new SQueue[T]((l2.reverse).tail,Nil)
      case (List(e), l2) => new SQueue[T](l2.reverse,Nil)
      case (hd::tl, l2) => new SQueue[T](tl,l2)
    }
  }

  def first():T = {
    queue match {
      case (hd::tl,l2) => hd
      case (Nil, _) => throw new EmptyQueueException()
    }
  }

  def isEmpty():Boolean = queue == (Nil,Nil)


}

val s = new SQueue[String]()

s.isEmpty()


val s1 = s.enqueue("a")
s1.first()

s1.isEmpty()

val s2 = s1.enqueue("b")

s2.first()

val s3 = s2.dequeue()

s3.first()


