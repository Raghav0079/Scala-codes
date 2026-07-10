object Class_Objects {
    def main(args: Array[String]): Unit = {
        println("classes and objects example")

        class Person(var name: String, var age: Int) {

            def greet(): String = {
                s"Hello, my name is $name and I am $age years old"
            }
        }

        val person1 = new Person("Raghav", 21)

        println(person1.greet()) 
    } 
}