object Main{
    def main( args : Array[String]) : Unit = {
        val nums = List(4,8,12,16,20)
        val sum = nums.foldLeft(0)(_ + _)

        val max = nums.max
        val evens = nums.filter(_ % 2 == 0)


        val doubled = nums.map(_ * 2)
        // output

        println(s"Sum: $sum")
        println(s"Max: $max")
        println(s"Evens: $evens")
        println(s"Doubled: $doubled")
    }
}