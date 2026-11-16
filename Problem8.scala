import scala.util.control.Breaks._

object Problem8 {
  def main(args: Array[String]): Unit = {
    // List (Immutable) vs Array (Mutable)
    val immList = List(10, 20, 30)
    val mutArray = Array(10, 20, 30)
    mutArray(0) = 99 // Valid in Array; immList(0) = 99 fails to compile

    // map returns a new collection; foreach returns Unit
    val doubled = immList.map(_ * 2)
    println(s"Mapped List: $doubled")
    print("Foreach output: ")
    mutArray.foreach(x => print(s"$x "))
    println()

    // Breaking a loop in Scala
    breakable {
      for (i <- 1 to 10) {
        if (i == 4) break()
        print(s"$i ")
      }
    }
  }
}