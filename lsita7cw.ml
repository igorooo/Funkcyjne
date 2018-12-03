
type 'a t = {mutable l : 'a list} (* Mozna zmieniac l dzieki mutable*)

let create() = { l = []}
let push(e,s) = s.l <- e::s.l  (* przypisanie do s.l nowej wartosci e::s.l , s.l = stack.l tzn dostep do elemenu l z typu s*)
 