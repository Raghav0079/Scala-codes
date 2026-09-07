import scala.io.StdIn

object input {
    def main(args: Array[String]): Unit = {
        println("Enter your name:")
        val name = StdIn.readLine()

        println("Enter your age:")
        val age = StdIn.readLine()

        println(s"Hello, $name")
        println(s"Age: $age")
    }
}