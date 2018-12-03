class Point(protected var x: Double = 0, protected var y: Double = 0) {
  def setX(newX: Double): this.type = { x = newX; this }
  def setY(newY: Double): this.type = { x = newY; this }
  def getX = x
  def getY = y
}
class Circle(x: Double = 0, y: Double = 0, protected var radius: Double = 0) extends Point(x, y) {
  def setRadius(newRadius: Double): this.type = { radius = newRadius; this }
  def getRadius = radius
}
class Cylinder(x: Double = 0, y: Double = 0, radius: Double = 0, protected var height: Double = 0) extends Circle(x, y, radius) {
  def setHeight(newHeight: Double): this.type = { height = newHeight; this }
  def getHeigh = height
}

object Figures extends App {
  val p = new Point(3, 4)
  val c = new Circle
  val cy = new Cylinder

  val c2: Circle = c.setX(2).setY(3).setX(3).setY(2).setX(4).setY(4)
}