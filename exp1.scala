import scala.io.StdIn
object exp1 {
  def main(args: Array[String]): Unit = {
    
    println("--- (a) Hello, World! ---")
    println("Hello, World!")

    println("\n--- (b) Variables (val and var) ---")
    
    var mutableVar = 10
    println(s"Initial var value: $mutableVar")
    mutableVar = 25 // Allowed because it is a 'var'
    println(s"Reassigned var value: $mutableVar")

    val immutableVal = 100
    println(s"val value: $immutableVal")

    println("\n--- (c) Data Types ---")
    val myInt: Int = 42
    val myLong: Long = 9876543210L
    val myDouble: Double = 3.14159265
    val myFloat: Float = 2.718f
    val myChar: Char = 'S'
    val myString: String = "Scala"
    val myBoolean: Boolean = true

    println(s"Int: $myInt, Long: $myLong")
    println(s"Double: $myDouble, Float: $myFloat")
    println(s"Char: $myChar, String: $myString, Boolean: $myBoolean")

    println("\n--- (d) Console I/O ---")
    print("Enter the first number (e.g., 15.5): ")
    val input1 = StdIn.readLine()
    
    print("Enter the second number (e.g., 4): ")
    val input2 = StdIn.readLine()

    val num1 = input1.toDouble 
    val num2 = input2.toDouble 
    
    // Type inference: Scala automatically infers 'inferredString' is of type String
    val inferredString = num1.toString 
    val sum = num1 + num2
    val diff = num1 - num2
    val prod = num1 * num2
    val div = num1 / num2
    val mod = num1 % num2
    val isGreater = num1 > num2
    val isEqual = num1 == num2
    val bothPositive = (num1 > 0) && (num2 > 0)
    val eitherPositive = (num1 > 0) || (num2 > 0)

    println("\n--- (e) String Interpolation & Operation Results ---")
    
    // Using s"" for standard variable injection
    println(s"Arithmetic: $num1 + $num2 = $sum")
    println(s"Arithmetic: $num1 - $num2 = $diff")
    println(s"Arithmetic: $num1 * $num2 = $prod")
    
    // Using f"" for formatted output (e.g., 2 decimal places)
    println(f"Arithmetic: $num1%.2f / $num2%.2f = $div%.2f")
    println(f"Arithmetic: $num1%.2f %% $num2%.2f = $mod%.2f")

    println(s"Relational: Is $num1 > $num2? $isGreater")
    println(s"Relational: Are they equal? $isEqual")
    
    println(s"Logical: Are both numbers positive? $bothPositive")
    println(s"Logical: Is at least one number positive? $eitherPositive")
    
    println(s"Conversion: Original input was $inferredString (converted to String using .toString)")
  }
}