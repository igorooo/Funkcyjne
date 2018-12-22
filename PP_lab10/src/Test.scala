object Test {

  def main(args: Array[String]): Unit = {

    val CSrules = "Two teams fighting on one of 8 avilable locations. Winner has to achive 16 of 30 rounds"

    val F_OLOF = new Player("Olof","Sweden",1)
    val F_JW = new Player("JW","Sweden",2)
    val F_FLUSH = new Player("FLUSH","Sweden",3)
    val F_PRONAX = new Player("PRONAX","Sweden",4)
    val F_KRIMZ = new Player("KRIMZ","Sweden",5)

    val A_DEV = new Player("Device","Denmark",1)
    val A_X = new Player("X3p9x","Denmark",2)
    val A_DUP = new Player("Dupreeh","Denmark",3)
    val A_GL = new Player("Glaive","Denmark",4)
    val A_MAG = new Player("Magisk","Denmark",5)

    val S_FAL = new Player("Fallen","Brazil",1)
    val S_C = new Player("Coldzera","Brazil",2)
    val S_FE = new Player("fer","Brazil",3)
    val S_FNX = new Player("fnx","Brazil",4)
    val S_T = new Player("TACO","Brazil",5)

    val CSGO = new eSPORTGAME("CounterStrike Global Offensive", CSrules, 2,5,"PC")

    val FNATIC = new Team[eSPORTGAME]("Fnatic",5,List(F_OLOF,F_JW,F_FLUSH,F_PRONAX,F_KRIMZ),CSGO)
    val ASTRALIS = new Team[eSPORTGAME]("Astralis",5,List(A_DEV,A_DUP,A_GL,A_MAG,A_X),CSGO)
    val SK = new Team[eSPORTGAME]("SK",5,List(S_C,S_FAL,S_FE,S_FNX,S_T),CSGO)

    val ESL = new eSportLeague("ESL","round-robin",3,List(FNATIC,ASTRALIS,SK),CSGO)

    ESL.presentation()
    ESL.prepare_schedule()

    println("Winner of " + FNATIC.NAME + " vs " + SK.NAME + " is: " + ESL.winner(FNATIC,SK).NAME)

  }

}
