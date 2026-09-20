object Main{
    case class Person(name: String , age:Int)

    def main(args:Array[String]) : Unit = {
        val people = List(
            Person("A", 22),
            Person("B", 15),
            Person("C", 32),
            Person("D", 17)
        )

        val adults = people
            .filter(_.age > 18)
            .map(_.name)
        
        // print names
        adults.foreach(println)
    }
}