case class Person(name: String, age: Int)

// 1. Type Class Definition
trait Show[A] {
  def show(a: A): String
}

// 2. Type Class Instances (provided via implicit objects/vals)
object ShowInstances {
  implicit val intShow: Show[Int] = new Show[Int] {
    def show(a: Int): String = s"Int value: $a"
  }

  implicit val personShow: Show[Person] = new Show[Person] {
    def show(p: Person): String = s"Person(${p.name}, age ${p.age})"
  }
}

// 3. Generic function accepting an implicit Show[A] instance
object Main {
  import ShowInstances._

  def printAll[A](xs: List[A])(implicit s: Show[A]): Unit = {
    xs.foreach(x => println(s.show(x)))
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3)
    val people = List(Person("Alice", 25), Person("Bob", 30))

    println("--- Printing Ints ---")
    printAll(numbers)

    println("\n--- Printing Persons ---")
    printAll(people)
  }
}