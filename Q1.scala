class Student(val name: String, val rollNo: Int, val marks: Array[Int]) {
  def percentage(): Double = {
    if (marks.isEmpty) 0.0
    else marks.sum.toDouble / marks.length
  }
}

object Q1 {
  def main(args: Array[String]): Unit = {
    val s1 = new Student("A", 101, Array(85, 90, 88))
    val s2 = new Student("B", 102, Array(70, 75, 80))
    val s3 = new Student("C", 103, Array(92, 95, 91))

    val students = List(s1, s2, s3)
    for (s <- students) {
      println(f"Name: ${s.name}%-10s | Percentage: ${s.percentage()}%.2f%%")
    }
  }
}

/*
Sample Output:
Name: A    | Percentage: 87.67%
Name: B    | Percentage: 75.00%
Name: C    | Percentage: 92.67%
*/