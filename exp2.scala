import scala.io.StdIn

object exp2 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 2 ==========")
    checkPositiveNegativeZero()
    findLargestOfThree()
    multiplicationTable()
    demonstrateForLoops()
    computeFactorial()
    printFibonacci()
    menuDrivenCalculator()
  }

  // (a) Check whether a number is positive, negative or zero (if returns a value)
  def checkPositiveNegativeZero(): Unit = {
    println("\n--- (a) Positive / Negative / Zero ---")
    print("Enter a number: ")
    val num = StdIn.readInt()
    
    // In Scala, if-else statements are expressions and return a value
    val result = if (num > 0) {
      "Positive"
    } else if (num < 0) {
      "Negative"
    } else {
      "Zero"
    }
    
    println(s"The number $num is $result.")
  }

  // (b) Find the largest of three numbers
  def findLargestOfThree(): Unit = {
    println("\n--- (b) Largest of Three Numbers ---")
    print("Enter three numbers separated by spaces (e.g., 10 25 5): ")
    val input = StdIn.readLine().split(" ").map(_.toInt)
    
    if (input.length >= 3) {
      val a = input(0)
      val b = input(1)
      val c = input(2)

      val largest = if (a >= b && a >= c) a
                    else if (b >= a && b >= c) b
                    else c

      println(s"The largest among $a, $b, and $c is $largest.")
    } else {
      println("Invalid input. Please enter exactly three numbers.")
    }
  }

  // (c) Print the multiplication table of a given number using a for loop
  def multiplicationTable(): Unit = {
    println("\n--- (c) Multiplication Table ---")
    print("Enter a number for its multiplication table: ")
    val n = StdIn.readInt()
    
    for (i <- 1 to 10) {
      println(f"$n%2d x $i%2d = ${n * i}%3d")
    }
  }

  // (d) Print numbers 1 to 20 using for with to, until, by, and if
  def demonstrateForLoops(): Unit = {
    println("\n--- (d) For Loop Variations (1 to 20) ---")
    
    println("Using 'to':")
    for (i <- 1 to 5) print(s"$i ") 
    println()

    println("Using 'until' (excludes upper bound):")
    for (i <- 1 until 6) print(s"$i ")
    println()

    println("Using 'by' (stepping by 3):")
    for (i <- 1 to 20 by 3) print(s"$i ")
    println()

    println("Using filter guard 'if' (Even numbers from 1 to 20):")
    for (i <- 1 to 20 if i % 2 == 0) print(s"$i ")
    println()
  }

  // (e) Compute factorial using while and do...while
  def computeFactorial(): Unit = {
    println("\n--- (e) Factorial using while and do...while ---")
    print("Enter a small positive integer: ")
    val n = StdIn.readInt()

    // 1. Using while loop
    var temp1 = n
    var factWhile: Long = 1
    while (temp1 > 0) {
      factWhile *= temp1
      temp1 -= 1
    }
    println(s"Factorial of $n using 'while' loop is: $factWhile")

    // 2. Using do...while loop (Note: do..while is supported in Scala 2.13, but removed in Scala 3)
    var temp2 = n
    var factDoWhile: Long = 1
    if (n > 0) {
      do {
        factDoWhile *= temp2
        temp2 -= 1
      } while (temp2 > 0)
    }
    println(s"Factorial of $n using 'do...while' loop is: $factDoWhile")
  }

  // (f) Print the Fibonacci series up to n terms
  def printFibonacci(): Unit = {
    println("\n--- (f) Fibonacci Series ---")
    print("Enter number of terms: ")
    val terms = StdIn.readInt()
    
    var t1 = 0
    var t2 = 1
    print(s"Fibonacci series up to $terms terms: ")
    
    for (_ <- 1 to terms) {
      print(s"$t1 ")
      val sum = t1 + t2
      t1 = t2
      t2 = sum
    }
    println()
  }

  // (g) Simple menu-driven calculator using match
  def menuDrivenCalculator(): Unit = {
    println("\n--- (g) Menu-Driven Calculator ---")
    print("Enter first number: ")
    val num1 = StdIn.readDouble()
    print("Enter second number: ")
    val num2 = StdIn.readDouble()
    
    println("Select an operation: [+] Add, [-] Subtract, [*] Multiply, [/] Divide")
    print("Enter operator: ")
    val operator = StdIn.readChar()

    // Pattern matching
    val result = operator match {
      case '+' => num1 + num2
      case '-' => num1 - num2
      case '*' => num1 * num2
      case '/' => 
        if (num2 != 0) num1 / num2 
        else "Error: Division by zero!"
      case _   => "Invalid Operator"
    }

    println(s"Result: $num1 $operator $num2 = $result")
  }
}