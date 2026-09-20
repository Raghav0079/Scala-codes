object Main{
    def applyTwice ( f: Int => Int , x : Int) : Int = f(f(x))

    def main( args : Array[String]) : Unit = {
        val square = (n : Int) => n *n
        val result = applyTwice(square , 3)

        println(s"Result: $result")
    }
}