object Main {

  def safeDivide(a: Int, b: Int): Option[Int] = {
    if (b == 0) None else Some(a / b)
  }

  def main(args: Array[String]): Unit = {

    // Runs two divisions safely
    val result = for {
      x <- safeDivide(20, 2) 
      y <- safeDivide(10, 2) 
    } yield x + y

    println(result) 

    // Fails safely if division by zero occurs
    val failResult = for {
      x <- safeDivide(20, 0) 
      y <- safeDivide(10, 2)
    } yield x + y

    println(failResult) 
  }
}