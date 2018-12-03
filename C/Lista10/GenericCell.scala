class GenericCellImm[T](val x: T)
class GenericCellImm[+T](val x: T)
class GenericCellMut[T](var x: T)
class GenericCellMut[+T](var x: T)
// Covariance works with immutable data since the only possible operation
// is an getter, which may be given a covariant return type (cause subtypes
// are "compatible").

//	abstract class Sequence[+A] { 
//	  def append(x: Sequence[A]): Sequence[A] 
//	}   
//	// <console>:14: error: covariant type A occurs in contravariant position in type 
//	// Sequence[A] of value x 
/**
 * Tak zdefiniowana metoda blokuje mo¿liwosc dodawania sekwencji z elementami podtypu typu A mimo, ¿e typ A jest kowariantny.
 * Nale¿y dostarczyc metode, która bedzie mogla przyjac elementy klasy rozszerzajacej typ okreslony przy tworzeniu nowej sekwencji
 */
/*
 * The problem is that A is covariant, while the "append" function expects its type parameter to be contravariant.
 * Thus, A is varying the wrong direction. Interestingly enough, we could solve this problem by making Sequence contravariant
 * in A, but then the return type Sequence[A] would be invalid as the cons function expects its return type to be covariant.
 */

//	T1' <: T1
//	T2 <: T2'
//	
//	Function1[T1, T2] <: Function1[T1', T2']
abstract class Sequence[+A] {
  def append[B >: A](x: Sequence[B]): Sequence[B]
}
/**
 * Tu zapewniamy, ¿e jesli A jest podtypem typu B, to bedzie zawsze mo¿na u¿yc bezpiecznie typu A
 * w kontekscie B.
 */
/*
 * This is now valid. You can imagine that A is varying downward, but B is able
 * to vary upward with respect to A since A is its lower-bound.
 * With this method declaration, we can have A be covariant and everything works out.
 */
