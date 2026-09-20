object Main {
  val Weekday = "(?i)monday|tuesday|wednesday|thursday|friday".r
  val Weekend = "(?i)saturday|sunday".r

  def dayType(day: String): String = day match {
    case Weekday() => "Weekday"
    case Weekend() => "Weekend"
    case _              => "Invalid day"
  }

  def main(args: Array[String]): Unit = {
    println(dayType("Monday"))    
    println(dayType("wednesday")) 
    println(dayType("SUNDAY"))    
  }
}