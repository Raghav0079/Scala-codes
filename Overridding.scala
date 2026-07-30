

class Student {
  def speak(): Unit = {
    println("I am a Student")
  }
}

class SchoolStudent extends Student {
  override def speak(): Unit = {
    println("I am a school student")
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val s = new SchoolStudent()
    s.speak()
  }
}


// when using inheritance and redefining a method we use overridding .
// in overridding classes and objects is not compulsory it can be done using simple functions also 
// in polymorphism its compulsory to create classes and objects .

