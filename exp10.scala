import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.{Using, Try, Success, Failure}

case class Student(rollNo: Int, name: String, marks: Double)

object Exp10 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 10 ==========")
    val textFile = "sample.txt"
    val csvFile = "students.csv"

    fileOperations(textFile)
    studentApplication(csvFile)
  }

  // ==========================================
  // Parts (a), (b), (c), (d): File Handling
  // ==========================================
  def fileOperations(filename: String): Unit = {
    println("\n--- (a) Write to File ---")
    val content = 
      """Scala is a functional programming language.
        |Scala is also an object-oriented language.
        |This file contains Scala code examples.
        |Scala is great for data processing.""".stripMargin

    // Using will automatically close the PrintWriter when the block finishes
    Using(new PrintWriter(new File(filename))) { writer =>
      writer.write(content)
    }
    println(s"Successfully wrote text to $filename")


    println("\n--- (b) Read File & Print Line Numbers ---")
    Using(Source.fromFile(filename)) { source =>
      for ((line, index) <- source.getLines().zipWithIndex) {
        println(s"${index + 1}: $line")
      }
    }


    println("\n--- (c) Count Lines, Words, and Characters ---")
    var lineCount = 0
    var wordCount = 0
    var charCount = 0

    Using(Source.fromFile(filename)) { source =>
      val lines = source.getLines().toList
      lineCount = lines.length
      charCount = lines.map(_.length).sum // Characters excluding newlines
      // Split by one or more spaces to find words
      wordCount = lines.flatMap(_.split("\\s+")).count(_.nonEmpty) 
    }
    println(s"Lines: $lineCount, Words: $wordCount, Characters: $charCount")


    println("\n--- (d) Word Frequency (Top 3) ---")
    Using(Source.fromFile(filename)) { source =>
      // Extract words, convert to lowercase, remove punctuation
      val words = source.getLines()
        .flatMap(_.split("\\s+"))
        .map(_.toLowerCase.replaceAll("[^a-z]", ""))
        .filter(_.nonEmpty)
        .toList

      // Group by the word itself, then map the grouped lists to their sizes
      val wordFrequency = words.groupBy(identity).map { case (word, list) => (word, list.size) }
      
      // Sort by frequency descending, then take top 3
      val top3Words = wordFrequency.toSeq.sortBy { case (word, count) => -count }.take(3)
      
      println("Top 3 most frequent words:")
      top3Words.foreach { case (word, count) => println(s"'$word': $count times") }
    }
  }

  // ==========================================
  // Parts (e), (f): Student Management App
  // ==========================================
  def studentApplication(csvFilename: String): Unit = {
    println("\n--- (e) Student Record Management ---")
    
    // Mutable reference to an immutable List
    var students: List[Student] = List(
      Student(101, "Alice", 85.5),
      Student(102, "Bob", 78.0)
    )

    // Add function
    def addStudent(s: Student): Unit = {
      students = students :+ s
      println(s"Added: ${s.name}")
    }

    // Search function
    def searchByRoll(roll: Int): Option[Student] = {
      students.find(_.rollNo == roll)
    }

    // Display all function
    def displayAll(): Unit = {
      println("Current Students:")
      students.foreach(s => println(s"  Roll: ${s.rollNo}, Name: ${s.name}, Marks: ${s.marks}"))
    }

    // Find topper function
    def findTopper(): Option[Student] = {
      students.maxByOption(_.marks)
    }

    // Operating the application
    addStudent(Student(103, "Charlie", 95.0))
    addStudent(Student(104, "Diana", 88.5))
    
    displayAll()

    val searchRoll = 103
    searchByRoll(searchRoll) match {
      case Some(student) => println(s"Found student with roll $searchRoll: ${student.name}")
      case None          => println(s"Student with roll $searchRoll not found.")
    }

    findTopper() match {
      case Some(topper) => println(s"Class Topper: ${topper.name} with ${topper.marks} marks")
      case None         => println("No students found.")
    }


    println("\n--- (f) Save to and Load from CSV ---")
    // Save to CSV
    Using(new PrintWriter(new File(csvFilename))) { writer =>
      writer.println("RollNo,Name,Marks") // CSV Header
      students.foreach { s =>
        writer.println(s"${s.rollNo},${s.name},${s.marks}")
      }
    }
    println(s"Successfully saved ${students.size} records to $csvFilename")

    // Load from CSV
    var loadedStudents: List[Student] = List()
    Using(Source.fromFile(csvFilename)) { source =>
      // drop(1) skips the header row
      loadedStudents = source.getLines().drop(1).map { line =>
        val parts = line.split(",")
        Student(parts(0).toInt, parts(1), parts(2).toDouble)
      }.toList
    }

    println("Records loaded back from CSV:")
    loadedStudents.foreach(println)
  }
}