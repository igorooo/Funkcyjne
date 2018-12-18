
object UzycieWyjatkow{

  def main(args: Array[String]): Unit = {

    try {
      metoda1()
    }

    catch {
      case e : Exception =>
        println(e.getMessage)
        e.printStackTrace()
    }

  }


  def metoda1():Unit = {
    metoda2()
  }

  def metoda2():Unit = {
    metoda3()
  }

  def metoda3():Unit = {
    throw new Exception( "Wyjatek zgloszony w metoda3" )
  }

}

/*
Wyjatek zgloszony w metoda3
java.lang.Exception: Wyjatek zgloszony w metoda3
	at UzycieWyjatkow$.metoda3(zad4.scala:28)
	at UzycieWyjatkow$.metoda2(zad4.scala:24)
	at UzycieWyjatkow$.metoda1(zad4.scala:20)
	at UzycieWyjatkow$.main(zad4.scala:7)
	at UzycieWyjatkow.main(zad4.scala)
 */
