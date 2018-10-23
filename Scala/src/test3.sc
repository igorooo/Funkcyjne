



val xs = List("Ala", "ma", "koto","psa")

val p::o = xs


//zad4

val List(_,_,x,_,_) = List(-2,-1,0,1,2)

val List((_,_),(y,_)) = List((1, 2), (0, 1))


def root3(a:Double):Double = {

  def root_3(x:Double):Double = if( ((x*x*x) - a).abs <= 1e-15 * a.abs ) x
                                else  root_3(x + (a/(x*x) - x)/3)
  if(a >=1) root_3(a/3)
  else root_3(a)
}

root3(9)
