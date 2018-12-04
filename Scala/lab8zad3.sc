

def duplicate[A] (list1:List[A], list2:List[Int]):List[A] = {

  def multi[A](elem:A, amount:Int):List[A] ={

    if(amount > 0) elem::multi(elem,amount-1)
    else Nil
  }

  (list1,list2) match {
    case (hd1::tl1, hd2::tl2) => multi(hd1,hd2):::duplicate(tl1,tl2)
    case (_,_) => Nil
  }

}

duplicate(List(1,2,3,4,5),List(1,2,3,4,5,6))