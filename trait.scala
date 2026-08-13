trait Greater{
    def name : String
    def greet() :String =  s"hello , $name"
}

class Employee( val name : String) extends Greater

object Main{
    def main (args: Array[String]) : Unit = {
        val employee = new Employee("Rahul")
        println(employee.name)
        println(employee.greet())
    }
}
