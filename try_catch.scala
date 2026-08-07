object HelloWorld {
  def main(args: Array[String]): Unit = {
val result: Int =
    try {
    10 / 0
    } catch {
     case _: ArithmeticException => -1
    } finally {
    println("cleanup runs regardless")   // finally's return value is discarded, for side effects only
    }

val s = 10/0
print(s)
    }
}