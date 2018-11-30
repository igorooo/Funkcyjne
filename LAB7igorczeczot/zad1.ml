
type eval = Num of float | Neg | Add | Sub | Mul | Div| Neutral;;

exception Ex of string;;

let stackMach lista =
  let rec funct list elA elB flag = if list = [] then elA else
    let h::t = list
    in match flag with
     | 0 -> (match h with
            | Neg -> funct t (elA *. (-1.)) elB 0
            | Num a -> funct t elA a 1
            | _ -> raise(Ex "wrong operation!") )
     | 1 -> (match h with
           | Add -> funct t (elA +. elB) 0. 0
           | Sub -> funct t (elA -. elB) 0. 0
           | Mul -> funct t (elA *. elB) 0. 0
           | Div -> funct t (elA /. elB) 0. 0
           | _ -> raise(Ex "wrong operation!") )
  in if lista = [] then 0. else let h::t = lista in match h with 
                                                    | Num a -> funct t a 0. 0
                                                    | _ -> raise(Ex "wrong operation!")
;;

let x = stackMach [Num 5.;Num 3.; Add;];;

let xx = stackMach [Num 5.;Num 3.; Add;Neg;Num 10.; Add;Num 5.; Mul; Num 4.; Div];;

let xxx = stackMach [Num 5.;Num 3.; Add;Neg;Num 10.; Add;Num 5.; Mul; Num 4.; Div; Sub];;
            
