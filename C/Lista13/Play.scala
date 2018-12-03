import scala.actors.Actor
import scala.collection.mutable.MutableList
import scala.util.Random

object Play {
	val players = new MutableList[Player]

	def main(args: Array[String]) {
		val p1 = new Player(1)
		val p2 = new Player(2)
		val p3 = new Player(3)

		players += p1 += p2 += p3

		p1.start
		p2.start
		p3.start

		p1 ! Ball(0)

		Thread.sleep(5000)

		val p4 = new Player(4)
		p4.start
		players += p4
	}

	case class Ball(count: Int)

	class Player(id: Int) extends Actor {
		val random = new Random
		def act {
			loop {
				Thread.sleep(1000)
				receive {
					case Ball(x) =>
						println("Throws count " + x + ". Ball received and thrown by user of ID " + id)
						players(random.nextInt(players.size)) ! Ball(x + 1)
				}
			}
		}
	}
}