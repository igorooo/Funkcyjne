

let sigma f m =
  let rec suma (i,s) =
    if i =m then s else suma(i+1, s+. f(i+1))
  in suma(0, f 0)
;;

let ff = function n -> n * n;;




let v = sigma(ff, 3);;