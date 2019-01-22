class Buffer {
  private var msg: String = _  //Message sent from producer to consumer.
  private var empty = true

  def put(msg: String) = this.synchronized {
    while (!empty) wait()  
    println(s"${Thread.currentThread.getName} puts $msg") 
    this.msg = msg
    empty = false
    notifyAll
  }
  
  def take: String = this.synchronized {
    while (empty) wait()   
    empty = true
    notifyAll
    println(s"${Thread.currentThread.getName} takes $msg") 
    msg
  }
}

class Producer(name: String, buf: Buffer) extends Thread(name) {
  override def run: Unit = {
    for (i <- 1 to 10) buf.put(s"m$i")
    buf.put("Done")
  }
}

class Consumer(name: String, buf: Buffer) extends Thread(name) {
  override def run {
     var msg = ""
     do {
        msg = buf.take

     } while (msg != "Done")
  }
}

object prodCons {
   def main(args: Array[String]) {
       val buf = new Buffer 
       new Producer("Producer", buf).start
       new Consumer("Consumer", buf).start
   }       
}
