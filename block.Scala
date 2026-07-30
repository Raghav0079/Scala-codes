// 2.create a program for block expression for multiplication and divsion 

object block{
    def main(args:Array [String]) : Unit={


        val x = 10 
        val y = 20 

        val expression={
            x +y
        }
        println(s"result: $expression")
    }
}