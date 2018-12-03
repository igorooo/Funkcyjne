// Zadanie 1
def swap[A](tab: Array[A], i: Int, j: Int) = {
  val temp = tab(i); tab(i) = tab(j); tab(j) = temp
}

def choosePivot[A](tab: Array[A], m: Int, n: Int) = tab((m + n) / 2)

def partition(tab: Array[Int], l: Int, r: Int) = {
  var (i, j, pivot) = (l, r, choosePivot(tab, l, r))
  while (i <= j) {
    while (tab(i) < pivot) i += 1
    while (pivot < tab(j)) j -= 1
    if (i <= j) swap(tab, i, j); i += 1; j -= 1
  }
  (i, j)
}

def quick(tab: Array[Int], l: Int, r: Int): Unit = {
  if (l < r) {
    val (i, j) = partition(tab, l, r)
    if (j - l < r - i) { quick(tab, l, j); quick(tab, i, r) }
    else { quick(tab, i, r); quick(tab, l, j) }
  }
  else ()
}

def quicksort(tab: Array[Int]) = quick(tab, 0, tab.length - 1)

// Zadanie 2
def whileLoop(condition: => Boolean)(expression: => Unit): Unit = {
  if (condition) {
    expression
    whileLoop(condition)(expression)
  }
}