import scala.util.{Try, Success, Failure}
case class User(name: String, role: String)
class InvalidAgeException(message: String) extends Exception(message)
object exp9{
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 9 ==========")
    demoPatternMatchingBasics()
    demoCollectionsAndCaseClasses()
    demoOptionType()
    demoTryCatchFinally()
    demoTrySuccessFailure()
    demoCustomException()
  }

  // ==========================================
  // (a) Match with literal, variable, type, guard, default
  // ==========================================
  def matchEverything(x: Any): Unit = {
    val result = x match {
      case 0                       => "Literal Pattern: Zero"
      case s: String               => s"Type & Variable Pattern: String of length ${s.length}"
      case i: Int if i > 0         => s"Guard Pattern: Positive integer $i"
      case i: Int                  => s"Guard Pattern fallback: Negative integer $i"
      case _                       => "Default Pattern (_): Unknown type or value"
    }
    println(s"Input '$x' -> $result")
  }

  def demoPatternMatchingBasics(): Unit = {
    println("\n--- (a) Basic Pattern Matching ---")
    matchEverything(0)
    matchEverything("Scala")
    matchEverything(42)
    matchEverything(-10)
    matchEverything(3.14)
  }


  // (b) Pattern matching on List, Tuple, Case Class
  def demoCollectionsAndCaseClasses(): Unit = {
    println("\n--- (b) Pattern Matching on List, Tuple, Case Class ---")
    // 1. List
    val list = List(10, 20, 30)
    list match {
      case head :: second :: tail => println(s"List match: head=$head, second=$second, rest=$tail")
      case _                      => println("Unknown list structure")
    }
    // 2. Tuple
    val tuple = ("Alice", 85)
    tuple match {
      case (name, score) => println(s"Tuple match: Name is $name, Score is $score")
    }
    // 3. Case Class
    val user = User("Bob", "Admin")
    user match {
      case User(n, "Admin") => println(s"Case Class match: $n is an Administrator")
      case User(n, role)    => println(s"Case Class match: $n has role $role")
    }
  }

  // (c) Option[Int]: match, getOrElse, map
  def safeDivide(num: Int, den: Int): Option[Int] = {
    if (den == 0) None else Some(num / den)
  }

  def demoOptionType(): Unit = {
    println("\n--- (c) Option Type ---")
    val validDiv = safeDivide(10, 2)
    val invalidDiv = safeDivide(10, 0)
    // Using match
    validDiv match {
      case Some(value) => println(s"Match (10/2): Success, result is $value")
      case None        => println("Match (10/2): Error, division by zero")
    }
    // Using getOrElse
    val result2 = invalidDiv.getOrElse(-1)
    println(s"getOrElse (10/0): fallback to default -> $result2")

    // Using map (transforms Some, ignores None)
    val doubledOption = validDiv.map(_ * 2)
    println(s"map (10/2) * 2: $doubledOption")
  }

  // (d) try, catch, finally
  def demoTryCatchFinally(): Unit = {
    println("\n--- (d) try, catch, finally ---")
    val badString = "123a"
    try {
      println(s"Attempting to parse '$badString'")
      val num = badString.toInt // Throws NumberFormatException
      val result = num / 0      // Throws ArithmeticException (won't reach here)
    } catch {
      case e: NumberFormatException => println(s"Caught NumberFormatException: ${e.getMessage}")
      case e: ArithmeticException   => println(s"Caught ArithmeticException: ${e.getMessage}")
    } finally {
      println("Finally block executed (always runs to clean up resources).")
    }
  }

  // (e) scala.util.Try with Success and Failure
  def demoTrySuccessFailure(): Unit = {
    println("\n--- (e) scala.util.Try ---")
    val stringList = List("10", "20", "abc", "30")
    println(s"Parsing list: $stringList")

    stringList.foreach { str =>
      Try(str.toInt) match {
        case Success(value) => println(s"Success: Parsed integer $value")
        case Failure(exception) => println(s"Failure: Cannot parse '$str' -> ${exception.getClass.getSimpleName}")
      }
    }
  }
  // (f) Custom Exception
  def checkAge(age: Int): Unit = {
    if (age < 18) {
      throw new InvalidAgeException(s"Age $age is too young. Must be 18 or older.")
    } else {
      println(s"Age $age is valid.")
    }
  }

  def demoCustomException(): Unit = {
    println("\n--- (f) Custom Exception ---")
    try {
      checkAge(16)
    } catch {
      case e: InvalidAgeException => println(s"Caught InvalidAgeException: ${e.getMessage}")
    }
  }
}