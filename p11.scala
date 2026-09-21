trait Animal {
  def sound: String
}

class Dog extends Animal {
  def sound: String = "Woof!"
}

class Cat extends Animal {
  def sound: String = "Meow!"
}

object Main {

  // Function placed INSIDE the object
  def makeSounds(animals: List[Animal]): Unit = {
    animals.foreach(animal => println(animal.sound))
  }

  def main(args: Array[String]): Unit = {
    val animals: List[Animal] = List(new Dog, new Cat)
    makeSounds(animals)
  }
}