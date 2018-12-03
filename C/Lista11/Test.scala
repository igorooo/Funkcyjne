case class Tuple[A, B](fst: A, snd: B) { override def toString() = "(" + fst + ", " + snd + ")" }

abstract class MutableTuple {
  type A
  type B

  val initA: A
  val initB: B

  private var fst: A = initA
  private var snd: B = initB

  def getA: A = fst
  def getB: B = snd

  def setA(x: A) = fst = x
  def setB(x: B) = snd = x
}

object Test extends App {
  // If no delimiter is found in the target string,
  // you gets an array of size 1 that is holding the original string,
  // even if it is empty it is still one string (no matter it is empty).
  import scala.collection.mutable._

  def splitBySpaces(str: String) = str.trim.split("\\s+")
  def createDictionary[T](wordsArray: Seq[T]) = wordsArray.groupBy(x => x).mapValues(_.length)
  def wordCounter(text: String) = {
    val words = splitBySpaces(text)
    new HashMap[String, Int] ++ createDictionary(words)
  }
  
  val text = "raz dwa dwa trzy trzy trzy cztery cztery cztery cztery"
  val dictionary = wordCounter(text)
  dictionary.foreach(println)

  val mt = new MutableTuple { type A = Int; type B = String; val initA = 1; val initB = "empty" }
}