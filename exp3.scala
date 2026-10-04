import scala.annotation.tailrec

object exp3 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 3 ==========")
    demoBasicFunctions()
    demoDefaultAndVarArgs()
    demoRecursion()
    demoTailRecursion()
    demoAnonymousFunction()
    demoHigherOrderFunction()
    demoCurryingAndNestedFunctions()
  }

  // ==========================================
  // (a) Basic Functions, Positional and Named Arguments
  // ==========================================
  def formatName(firstName: String, lastName: String): String = {
    s"$lastName, $firstName"
  }

  def demoBasicFunctions(): Unit = {
    println("\n--- (a) Basic Functions & Arguments ---")
    
    // Positional arguments
    val name1 = formatName("Alan", "Turing")
    println(s"Positional call: $name1")
    
    // Named arguments (order doesn't matter)
    val name2 = formatName(lastName = "Lovelace", firstName = "Ada")
    println(s"Named call: $name2")
  }

  // ==========================================
  // (b) Default Parameters and Variable Arguments
  // ==========================================
  def calculatePrice(basePrice: Double, taxRate: Double = 0.05): Double = {
    basePrice + (basePrice * taxRate)
  }

  def sumAll(numbers: Int*): Int = {
    var sum = 0
    for (n <- numbers) sum += n
    sum
  }

  def demoDefaultAndVarArgs(): Unit = {
    println("\n--- (b) Default Params & VarArgs ---")
    
    // Uses default taxRate of 0.05
    println(s"Price with default tax: ${calculatePrice(100.0)}") 
    // Overrides default taxRate with 0.18
    println(s"Price with custom tax: ${calculatePrice(100.0, 0.18)}") 
    
    // Passing multiple arguments (variable length)
    println(s"Sum of 1, 2, 3, 4, 5 is: ${sumAll(1, 2, 3, 4, 5)}")
    println(s"Sum of 10 and 20 is: ${sumAll(10, 20)}")
  }

  // ==========================================
  // (c) Standard Recursion
  // ==========================================
  def factorial(n: Int): Long = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def demoRecursion(): Unit = {
    println("\n--- (c) Standard Recursion ---")
    println(s"Factorial of 5: ${factorial(5)}")
    println(s"7th Fibonacci number (0-indexed): ${fibonacci(7)}")
  }

  // ==========================================
  // (d) Tail Recursion
  // ==========================================
  @tailrec
  def factorialTail(n: Int, accumulator: Long = 1): Long = {
    if (n <= 1) accumulator
    else factorialTail(n - 1, n * accumulator)
  }

  def demoTailRecursion(): Unit = {
    println("\n--- (d) Tail Recursion vs Normal ---")
    println(s"Normal Factorial of 6: ${factorial(6)}")
    println(s"Tail-Recursive Factorial of 6: ${factorialTail(6)}")
    println("Note: Tail recursion prevents StackOverflowError for large 'n' because the compiler optimizes it into a loop.")
  }

  // ==========================================
  // (e) Anonymous Function (Lambda)
  // ==========================================
  def demoAnonymousFunction(): Unit = {
    println("\n--- (e) Anonymous Function ---")
    
    // Storing a lambda in a val
    val square = (x: Int) => x * x
    val isEven = (n: Int) => n % 2 == 0

    println(s"Square of 8 is: ${square(8)}")
    println(s"Is 14 even? ${isEven(14)}")
  }

  // ==========================================
  // (f) Higher-Order Functions
  // ==========================================
  def applyTwice(f: Int => Int, x: Int): Int = {
    f(f(x))
  }

  def demoHigherOrderFunction(): Unit = {
    println("\n--- (f) Higher-Order Function ---")
    val doubleIt = (x: Int) => x * 2
    
    val result = applyTwice(doubleIt, 5) // (5 * 2) * 2 = 20
    println(s"Applying 'doubleIt' twice to 5 yields: $result")
    
    // We can also pass an inline anonymous function
    val result2 = applyTwice(x => x + 10, 5) // (5 + 10) + 10 = 25
    println(s"Applying '+10' twice to 5 yields: $result2")
  }

  // ==========================================
  // (g) Currying and Nested (Local) Functions
  // ==========================================
  // Curried function definition
  def multiply(a: Int)(b: Int): Int = a * b

  def demoCurryingAndNestedFunctions(): Unit = {
    println("\n--- (g) Currying & Nested Functions ---")
    
    // Currying application
    val resultCurry = multiply(4)(5)
    println(s"Curried multiply(4)(5): $resultCurry")
    
    // Partial application of the curried function
    val multiplyByThree = multiply(3) _
    println(s"Partially applied (multiplyByThree(10)): ${multiplyByThree(10)}")

    // Nested (local) function
    def calculateStats(numbers: Array[Int]): String = {
      // Local function, only accessible inside calculateStats
      def findAverage(arr: Array[Int]): Double = {
        arr.sum.toDouble / arr.length
      }
      
      val min = numbers.min
      val max = numbers.max
      val avg = findAverage(numbers)
      
      s"Min: $min, Max: $max, Avg: $avg"
    }

    val data = Array(10, 20, 30, 40)
    println(s"Stats for [10, 20, 30, 40] -> ${calculateStats(data)}")
  }
}