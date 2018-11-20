

def whileLoop(condition: => Boolean)(expression: => Unit): Unit = {
  if (condition) {
    expression
    whileLoop(condition)(expression)
  }
}

var x:Int = 1

whileLoop(x < 10)({x = x + 1;println("a")})
