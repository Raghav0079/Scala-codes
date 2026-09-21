object Main{
    def greet(name : String) ( implicit greeting : String) : String = {
        s"$greeting , $name!"
    }

    def main(args : Array[String]) : Unit = {
        implicit val defaultGreeting : String = "hello"

        println(greet("Alice")) // Outputs: Hello, Alice!
        println(greet("Bob"))   // Outputs: Hello, Bob!

    
        println(greet("Charlie")("Welcome"))
    }
}