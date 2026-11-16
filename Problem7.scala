object Problem7 {
  def safeDivide(a: Int, b: Int): Option[Int] = {
    try {
      Some(a / b)
    } catch {
      case _: ArithmeticException => None
    }
  }

  def main(args: Array[String]): Unit = {
    val pairs = List((10, 2), (15, 0), (20, 4))

    for ((num, den) <- pairs) {
      val result = safeDivide(num, den)
      val displayValue = result.getOrElse(-1)
      println(s"$num / $den => Raw: $result, Unwrapped: $displayValue")
    }
  }
}