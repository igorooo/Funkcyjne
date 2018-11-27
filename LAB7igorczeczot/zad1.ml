type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

type eval = Num of float | Neg | Add | Sub | Mul | Div| Neutral;;

exception Ex of string;;

let rec funct stack elemA elemB=
  match (List.hd stack) with
  |[] -> elemA
  |Num a -> if(elemA <> Neutral) then funct (List.tl stack) (List.hd stack) Neutral
          else ( if elemB <> Neutral then funct (List.tl stack) elemA (List.hd stack)
                 else raise(Ex "wrong operation!"))
  |Neg -> if(elemA <> Neutral) 
            then let eff = elemA *. (-1.0) in funct (List.tl stack) eff Neutral
          else raise(Ex "wrong operation!")
  |Add -> if(elemA <> Neutral && elemB <> Neutral) 
            then let eff = elemA +. elemB in funct (List.tl stack) eff Neutral
          else raise(Ex "wrong operation!")
  |Sub -> if(elemA <> Neutral && elemB <> Neutral) 
            then let eff = elemA -. elemB in funct (List.tl stack) eff Neutral
          else raise(Ex "wrong operation!")
  |Mul -> if(elemA <> Neutral && elemB <> Neutral) 
            then let eff = elemA *. elemB in funct (List.tl stack) eff Neutral
          else raise(Ex "wrong operation!")
  |Div -> if(elemA <> Neutral && elemB <> Neutral) 
            then let eff = elemA /. elemB in funct (List.tl stack) eff Neutral
          else raise(Ex "wrong operation!")
;;

  