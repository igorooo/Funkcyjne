class Pojazd(private val Producent: String, private val Model: String,
             private val PYear: Int = -1, private var CarNumber: String = "") {

  def this(prod: String, mod: String, cnum: String) {
    this(prod,mod,-1,cnum)
  }

}

// producent model
// producent model pyear
// producent model carnumber
// producent model pyear carnumber

//konstruktor glowny powinien byc 4 parametrowy, poniewaz:
// 1. utworzenie pól klasy z poziomu listy argumentow
// 2. wskazanie parametrow obowiazkowych oraz opcjonalnych
// 3. nadanie opcjonalnym wartosci domyslnych

var p1 = new Pojazd("Volvo","A")

var p2 = new Pojazd("Volvo","A",2008)

var p3 = new Pojazd("Volvo","A","NDZ123")

var p4 = new Pojazd("Volvo","A", 2008, "NDZ123" )

