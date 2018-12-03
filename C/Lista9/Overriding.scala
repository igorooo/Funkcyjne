class A { override def toString() = "return z klasy A; " }
class B extends A { override def toString() = "return z klasy B; " }
class C extends B { override def toString() = "return z klasy C; " }

object Overriding extends App {
  Array(new C, new B, new A).foreach(print)
}