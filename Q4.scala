class Animal {
  def sound(): String = "Some generic sound"
}

class Dog extends Animal {
  override def sound(): String = "Woof"
}

class Cat extends Animal {
  override def sound(): String = "Meow"
}

class Cow extends Animal {
  override def sound(): String = "Moo"
}

object Q4 {
  def main(args: Array[String]): Unit = {
    val animals: List[Animal] = List(new Dog(), new Cat(), new Cow())

    for (animal <- animals) {
      println(s"${animal.getClass.getSimpleName} says: ${animal.sound()}")
    }
  }
}

/*
Sample Output:
Dog says: Woof
Cat says: Meow
Cow says: Moo
*/