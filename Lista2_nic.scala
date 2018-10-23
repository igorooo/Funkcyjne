object Main {
  def main(args: Array[String]) = {

    println(root3(0))
    println(root3(1))
    println(root3(8))
    println(root3(26))
    println(root3(27))

    println(initSetgment(List(), List()))
    println(initSetgment(List(2, 3, 4), List()))
    println(initSetgment(List(), List(2, 3, 4)))
    println(initSetgment(List(1, 2, 3), List(1, 2, 3, 4, 5, 6)))
    println(initSetgment(List(1, 2), List(3, 4, 5)))

    println(replace_nth(List(), 1, 5))
    println(replace_nth(List(2, 3, 4), 0, 5))
    println(replace_nth(List(2, 3, 4), 1, 5))
    println(replace_nth(List(2, 3, 4), 4, 5))
  }

  /** Zadanie 1 */
  /* evenR(3) =>
 * 	oddR(2) =>
 * 		evenR(1) =>
 * 			oddR(0) =>
 * false
 * _ = 4 elementy stosu
 */

  /** Zadanie 2 */
  def fibb(n: Int): Long = {
    if(n >= 0) {
	    if (n < 2) n
	    else fibb(n - 1) + fibb(n - 2)
    }
    else throw new IllegalArgumentException
  }

  def fibb_tail(n: Int) = {
      def help(n: Int, acc: Int, result: Int): Int = {
        if (n == 0) acc
        else help(n - 1, result, acc + result)
      }
    help(n, 0, 1)
  }

  def time(fun: Int => Long, n: Int) = {
    val start = System.nanoTime()
    fun(n)
    (System.nanoTime() - start) / 1000000
  }

  /** Zadanie 3 */
  def root3(a: Double) = {
      def help(x: Double): Double = {
        if ((x * x * x - a).abs <= 1e-15 * a.abs) x
        else help(x + (a / (x * x) - x) / 3)
      }
    help(if (a >= 1) a / 3 else a)
  }

  /** Zadanie 4 */
  // a)
  val List(_, _, x, _, _) = List(-2, -1, 0, 1, 2)
  // b)
  val (_, _) :: (y, _) :: Nil = List((1, 2), (0, 1))

  /** Zadanie 5 */
  def initSetgment[A](firstList: List[A], secondList: List[A]): Boolean = {
    (firstList, secondList) match {
      case (h1 :: t1, h2 :: t2) => h1 == h2 && initSetgment(t1, t2)
      case (Nil, _) => true
      case _ => false
    }
  }

  /** Zadanie 6 */
  def replace_nth[A](list: List[A], nth: Int, elem: A): List[A] = {
    list match {
      case Nil => Nil
      case head :: tail =>
        (if (nth != 0) head else elem) :: replace_nth(tail, nth - 1, elem)
    }
  }
}