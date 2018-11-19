
let primes to_n = 
  let rec sieve n =
    if n <= to_n then n::sieve(n+1) else []
  and find_primes xs =
    match xs with
    |h::t -> h::find_primes (List.filter ( fun x -> x mod h <> 0) t)
    |[] -> []
  in find_primes(sieve 2);;

primes 20;;

let xs = [1;2;3;4;5];;

List.fold_left (fun x y-> x+y) 0 xs;;

let silnia n = 
  let rec f (i, s) = if i < n then f(i+1,i*s) else i*s
  in f(1,1);;

silnia 4;;