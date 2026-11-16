object Problem4 {
  def getMinMax(m: Map[String, Int]): (Int, Int) = {
    val values = m.values
    (values.max, values.min)
  }

  def main(args: Array[String]): Unit = {
    val subjectMarks = Map("CS101" -> 85, "CS102" -> 90, "CS101" -> 95)

    println(s"Map contents: $subjectMarks")
    println(s"Map size: ${subjectMarks.size}") // Key "CS101" was overwritten with 95

    val stats: (Int, Int) = getMinMax(subjectMarks)
    println(s"Max Marks: ${stats._1}, Min Marks: ${stats._2}")
  }
}