object Main {
  def main(args: Array[String]): Unit = {
    val people = List(("A", 45), ("B", 17))
    
    val sorted = people.sortBy { case (name, age) => 
      (age, name)
    }(Ordering.Tuple2(Ordering.Int, Ordering.String.reverse))

    println(sorted)
  }
}