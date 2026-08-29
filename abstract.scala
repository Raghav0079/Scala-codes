abstract class Person {
    def age(): Unit
}

class Student extends Person {
    override def age(): Unit = {
        println("student age is 20")
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        val student = new Student()
        
        // Polymorphic reference: referring to a concrete Student as a Person
        val person: Person = new Student() 
        
        student.age()
        person.age()
    }
}