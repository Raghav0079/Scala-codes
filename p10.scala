import scala.annotation.tailrec

def factorial( n : BigInt) : BigInt = 
    if ( n<=1) 1 else n * factorial(n-1)

def factorialTailRec(n: BigInt): BigInt = {
  @tailrec
  def loop(n: BigInt, acc: BigInt): BigInt = 
    if (n <= 1) acc else loop(n - 1, acc * n)
  
  loop(n, 1)
}


println(factorial(5))        
println(factorialTailRec(5)) 