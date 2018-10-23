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


let rec sum(a,b) = [[((if List.hd a = [] then 0 else List.hd a) + (if List.hd b = [] then 0 else List.hd b))]
                                  @ sum(List.tl a, List.tl b)];;


let rec sqrList(x) = if x = [] then [] else ([List.hd x * List.hd x] @ sqrList(List.tl x) );;

         



let rec sum(a,b) =
  if( a = [] && b = []) then []
  else if( a = [] && b != []) then [List.hd b] @ sum([], List.tl b)
  else if( a != [] && b = []) then [List.hd a] @ sum(List.tl a, [])
  else [List.hd a + List.hd b ] @ sum(List.tl a,List.tl b);;


sum([1;2;3;4],[1;2;3;4;5]);;

let suma(a,b) =
  let rec summ(a,b,res) = 
    if( a = [] && b = []) then res
    else if( a = [] && b != []) then summ([], List.tl b, res @ [List.hd b]) 
    else if( a != [] && b = []) then summ(List.tl a, [], res @ [List.hd a])
    else summ(List.tl a, List.tl b, res @ [List.hd a + List.hd b ])
  in summ(a,b,[]);; 


suma([1;2;3;4],[1;2;3;4;5]);;

def sum(a:List[Int],b:List[Int]):List[Int] =
  if (a == Nil && b == Nil ) List()
  else if ( a == Nil && b != Nil){ b.head :: sum(Nil,b.tail) }
  else if( a != Nil && b == Nil) a.head :: sum(a.tail, Nil)
  else ( a.head + b.head ) :: sum(a.tail,b.tail)
