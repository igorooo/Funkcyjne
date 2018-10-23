let rec count(a, xs) = if xs=[] then 0
else if List.hd xs = a then 1+(count(a, List.tl xs))
else count(a, List.tl xs);;
count ('a', ['a'; 'l'; 'a']);;


let rec power(n) = if n = 0 then 1 else n*power(n-1);;

power(3);;

let rec fib(n) = if n < 2 then ( if n == 1 then 1 else 0) else fib(n-1) + fib(n-2);;

fib(10);;

let rec fibo_tail(n, a, b) = if n = 0 then b else fibo_tail(n-1, a+b, a);;

let fib_tail(n) = 
  let rec fibo_tail(n, a, b) = if n = 0 then b else fibo_tail(n-1, a+b, a)
  in fibo_tail(n,1,0);;

fib_tail(10);;
fibo_tail(10,1,0);;

let [_;_;x;_;_] = [-2;-1;0;1;2];;

let [(_,_);(y,_)] = [(1,2);(0,1)];;



let root3(a) = 
  let rec root_3(x) = if abs_float((x*.x*.x)-.a) <= 1e-15 *. abs_float(a) then x
                      else root_3(x +. (a/.(x*.x) -.x)/.3.)
  in ( if a >= 1. then root_3(a/.3.) else root_3(a));;

root3(9.);;

