object Hello { // Matches Hello.scala
  def greet(name: String): Unit = {
    println(s"Hello, $name from Scala 2!")
  }

  def main(args: Array[String]): Unit = {
    greet("Raghav")
  }
}