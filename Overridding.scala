

class Car {
  def variant(): Unit = {
    println("It's a Car")
  }
}

class Sedan extends Car {
  override def variant(): Unit = {
    println("It's a sedan car")
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val v = new Sedan()
    v.variant()
  }
}



