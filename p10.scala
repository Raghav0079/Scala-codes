import scala.annotation.tailrec

object Main {

  // 1. Standard (Non-Tail) Recursive Factorial
  def factorial(n: Int): BigInt = {
    if (n <= 1) 1
    else n * factorial(n - 1) // Multiplication happens AFTER returning
  }

  // 2. Tail-Recursive Factorial
  def factorialTailRec(n: Int): BigInt = {
    @tailrec
    def loop(current: Int, acc: BigInt): BigInt = {
      if (current <= 1) acc
      else loop(current - 1, acc * current) // Pure tail call
    }

    loop(n, 1)
  }

  def main(args: Array[String]): Unit = {
    println(s"Standard: ${factorial(5)}")         // 120
    println(s"Tail-Recursive: ${factorialTailRec(5)}") // 120
  }
}