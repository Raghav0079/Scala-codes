object Main {
  def main(args: Array[String]): Unit = {

    val a = List(1, 2, 3)
    val b = List("x", "y")

    // For-comprehension generating all pairs (cartesian product)
    val pairs = for {
      x <- a
      y <- b
    } yield (x, y)

    println(pairs)
  }
}