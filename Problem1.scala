object Problem1 {
  def main(args: Array[String]): Unit = {
    val name = "Aarav"        // Immutable, inferred as String
    var marks = 82.5          // Mutable, inferred as Double
    marks += 5.25

    println(f"Student $name scored $marks%.2f%%")
  }
}