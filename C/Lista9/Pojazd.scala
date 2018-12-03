class Pojazd(val producer: String, val model: String, val productionYear: Int = -1, var registrationNumber: String = "")

4 konstruktory:
var p1 = new Pojazd("vw", "golf 1")
var p1 = new Pojazd("vw", "golf 1", 1990)
var p1 = new Pojazd("vw", "golf 1", 1990, "HFP")
var p1 = new Pojazd("vw", "golf 1", registrationNumber = "HFP") // argument nazwany (podawany jako ostatni)