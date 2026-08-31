class Rectangle(val length: Double, val breadth: Double) {
  def this(side: Double) = {
    this(side, side)
  }

  def area(): Double = length * breadth
}

object Q2 {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(10.0, 5.0)
    val square = new Rectangle(4.0)

    println(s"Rectangle Area (10 x 5): ${rect.area()}")
    println(s"Square Area (4 x 4): ${square.area()}")
  }
}

/*
Sample Output:
Rectangle Area (10 x 5): 50.0
Square Area (4 x 4): 16.0
*/