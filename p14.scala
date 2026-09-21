import scala.util.{Try, Success, Failure}

object Main {

  
  def safeParseInt(str: String): Try[Int] = {
    Try(str.toInt)
  }

  
  def processInput(input: String): Unit = {
    safeParseInt(input) match {
      case Success(number) => 
        println(s"Successfully parsed number: $number")
      case Failure(exception) => 
        println(s"Failed to parse '$input': ${exception.getMessage}")
    }
  }

  def main(args: Array[String]): Unit = {
    processInput("123")   
    processInput("abc")   
    processInput("45.67")
  }
}