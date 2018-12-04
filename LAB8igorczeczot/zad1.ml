

let rec connect l1 l2 =
  match (l1, l2) with
  |([], []) -> []
  |([], hd::tl) -> l2
  |(hd::tl, []) -> l2
  |(hd1::tl1, hd2::tl2) -> hd1::hd2::connect tl1 tl2
;;

connect [1;2;3;4] [5;6;7;8;9;10];;