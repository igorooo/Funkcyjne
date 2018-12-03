object UzycieWyjatkow {
  def main(args: Array[String]) = {
    try { metoda1 }
    catch {
      case e: Throwable => {
        println(e.getMessage)
        e.printStackTrace
      }
    }
  }
  @throws(classOf[Exception])
  def metoda1 = metoda2

  @throws(classOf[Exception])
  def metoda2 = metoda3

  @throws(classOf[Exception])
  def metoda3 = throw new Exception("Wyjatek zgloszony w metoda3")
}

//	java.lang.Exception: Wyjatek zgloszony w metoda3
//	Wyjatek zgloszony w metoda3
//		at UzycieWyjatkow$.metoda3(UzycieWyjatkow.scala:14)
//		at UzycieWyjatkow$.metoda2(UzycieWyjatkow.scala:13)
//		at UzycieWyjatkow$.metoda1(UzycieWyjatkow.scala:12)		
//		at UzycieWyjatkow$.main(UzycieWyjatkow.scala:3)			// linia, w której zostal przechwycony wyjatek
//		at UzycieWyjatkow.main(UzycieWyjatkow.scala)			// metoda, w ktrej zostal przechwycony wyjatek

//	Compiled from "UzycieWyjatkow.scala"
//	public final class UzycieWyjatkow {
//	  public static scala.runtime.Nothing$ metoda3() throws java.lang.Exception;
//	  public static scala.runtime.Nothing$ metoda2() throws java.lang.Exception;
//	  public static scala.runtime.Nothing$ metoda1() throws java.lang.Exception;
//	  public static void main(java.lang.String[]);
//	}