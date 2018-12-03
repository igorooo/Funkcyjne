class Queue[T] private (val l1: List[T], val l2: List[T]) {
  class EmptyException(message: String) extends Exception(message)

  def this() = this(Nil, Nil)

  def enqueue(elem: T) = {
    (l1, l2) match {
      case (Nil, Nil) => new Queue(List(elem), Nil)
      case (lt1, lt2) => new Queue(l1, elem :: l2)
    }
  }

  def dequeue() = {
    (l1, l2) match {
      case (Nil, Nil) => this
      case (List(_), l) => new Queue(l.reverse, Nil)
      case (_ :: t, l) => new Queue(t, l)
    }
  }

  def first() =
    (l1, l2) match {
      case (Nil, Nil) => throw new EmptyException("Kolejka jest pusta!")
      case (h :: _, _) => h
      case _ => throw new EmptyException("B³¹d implementacji!")
    }

  def isEmpty = l1 == Nil
}