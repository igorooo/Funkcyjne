

let code n =
  let rec code_ (n, nRes, cur, aCur) = 
    if( n = []) then List.rev ((aCur,cur)::nRes)
    else
      if(List.hd n = cur) then code_ (List.tl n, nRes, cur, (aCur+1))
      else code_( List.tl n, (aCur,cur)::nRes, List.hd n, 1)
      in (if n <> [] then code_ (n, [], List.hd n, 0) else []);;

code ['a';'a';'a';'a';'b';'b';'b';'c';'c';'c';'b'] ;;
code ['1';'1';'2';'1';'3';'3';'3';'1'];;
code [];;
code ['a';'a';'a';'a';'a'];;
