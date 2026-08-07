object HelloWorld {
    def main(args: Array[String]): Unit = {
        // Removed the extra spacing around hyphens and the leading space
        val datePattern = """(\d{4})-(\d{2})-(\d{2})""".r

        val sampleDate = "2026-08-07"

        sampleDate match {
            case datePattern(year, month, day) => 
                println(s"Year: $year, Month: $month, Day: $day")
            case _ => 
                println("Date format did not match.")
        }
    }
}