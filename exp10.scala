import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.Using

// Fixed: Added missing closing parenthesis ')'
case class Student(rollNo: Int, name: String, marks: Double)

object Exp10 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 10 ==========")
    val textFileName = "sample_text.txt"
    val csvFileName = "students.csv"

    // Execute File Handling Blocks
    partA_writeToFile(textFileName)
    partB_readFromFile(textFileName)
    partC_countStats(textFileName)
    partD_wordFrequency(textFileName)

    // Execute Student App Blocks
    val finalStudents = partE_studentApp()
    partF_csvOperations(csvFileName, finalStudents)
  }

  // ==========================================
  // (a) Write text to a file using PrintWriter
  // ==========================================
  def partA_writeToFile(filename: String): Unit = {
    println("\n--- (a) Write to File ---")
    val content = 
      """Scala is a powerful language.
        |Scala supports functional programming.
        |Learning Scala is fun and Scala is great!""".stripMargin

    Using(new PrintWriter(new File(filename))) { writer =>
      writer.write(content)
    }
    println(s"Successfully wrote lines to '$filename'.")
  }

  // ==========================================
  // (b) Read file, print with line numbers, close properly
  // ==========================================
  def partB_readFromFile(filename: String): Unit = {
    println("\n--- (b) Read File & Print Line Numbers ---")
    
    Using(Source.fromFile(filename)) { source =>
      for ((line, index) <- source.getLines().zipWithIndex) {
        println(s"Line ${index + 1}: $line")
      }
    }
  }

  // ==========================================
  // (c) Count lines, words, and characters
  // ==========================================
  def partC_countStats(filename: String): Unit = {
    println("\n--- (c) Count Lines, Words, and Characters ---")
    
    Using(Source.fromFile(filename)) { source =>
      val lines = source.getLines().toList
      val lineCount = lines.length
      val charCount = lines.map(_.length).sum // excludes newline characters
      val wordCount = lines.flatMap(_.split("\\s+")).count(_.nonEmpty)
      
      println(s"Total Lines: $lineCount")
      println(s"Total Words: $wordCount")
      println(s"Total Characters: $charCount")
    }
  }

  // ==========================================
  // (d) Word frequency (Top 3) using groupBy and map
  // ==========================================
  def partD_wordFrequency(filename: String): Unit = {
    println("\n--- (d) Word Frequency (Top 3) ---")
    
    Using(Source.fromFile(filename)) { source =>
      // Extract words, convert to lowercase, and strip punctuation
      val words = source.getLines()
        .flatMap(_.split("\\s+"))
        .map(_.toLowerCase.replaceAll("[^a-z]", ""))
        .filter(_.nonEmpty)
        .toList

      // groupBy creates Map[String, List[String]], map transforms it to Map[String, Int]
      val wordFrequency = words.groupBy(identity).map { case (word, list) => (word, list.size) }
      
      // Sort by frequency in descending order and take top 3
      val top3 = wordFrequency.toSeq.sortBy { case (_, count) => -count }.take(3)
      
      println("Top 3 most frequent words:")
      top3.foreach { case (word, count) => println(s"'$word': $count times") }
    }
  }

  // (e) Student Record Management Application
  def partE_studentApp(): List[Student] = {
    println("\n--- (e) Student Record Management ---")
    // Mutable reference to hold our immutable Lists
    var students: List[Student] = List()

    // Inner functions for operations
    def addStudent(s: Student): Unit = {
      students = students :+ s
      println(s"Added student: ${s.name}")
    }
    def searchByRoll(rollNo: Int): Option[Student] = {
      students.find(_.rollNo == rollNo)
    }
    def displayAll(): Unit = {
      println("Displaying all students:")
      students.foreach(s => println(s"  -> Roll: ${s.rollNo}, Name: ${s.name}, Marks: ${s.marks}"))
    }
    def findTopper(): Option[Student] = {
      students.maxByOption(_.marks)
    }

    // Demonstrating the operations
    addStudent(Student(1, "Alice", 88.5))
    addStudent(Student(2, "Bob", 72.0))
    addStudent(Student(3, "Charlie", 95.5))
    displayAll()

    val searchRoll = 3
    searchByRoll(searchRoll) match {
      case Some(s) => println(s"Search found: ${s.name} with ${s.marks} marks")
      case None    => println(s"Student with Roll No $searchRoll not found.")
    }

    findTopper() match {
      case Some(t) => println(s"Class Topper is: ${t.name} (${t.marks} marks)")
      case None    => println("No students available.")
    }

    // Return the final list to be used in part (f)
    students
  }

  // (f) Save to CSV and Load back to List[Student]
  def partF_csvOperations(filename: String, students: List[Student]): Unit = {
    println("\n--- (f) Save to and Load from CSV ---")
    
    // 1. Save to CSV
    Using(new PrintWriter(new File(filename))) { writer =>
      writer.println("RollNo,Name,Marks") // Header
      students.foreach { s =>
        writer.println(s"${s.rollNo},${s.name},${s.marks}")
      }
    }
    println(s"Saved ${students.size} records to $filename.")

    // 2. Load from CSV back into a List
    var loadedStudents: List[Student] = List()
    Using(Source.fromFile(filename)) { source =>
      loadedStudents = source.getLines()
        .drop(1) // Skip the header row
        .filter(_.trim.nonEmpty)
        .map { line =>
          val cols = line.split(",")
          Student(cols(0).toInt, cols(1), cols(2).toDouble)
        }.toList
    }
    println("Successfully loaded records back from CSV:")
    loadedStudents.foreach(println)
  }
}