import scala.io.StdIn
object Experiment4 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 4 ==========")
    stringOperations()
    checkPalindrome()
    countVowelsConsonants()
    arrayBasicOperations()
    arrayReverseSortAccess()
    matrixOperations()
    linearSearch()
  }
  // (a) String length, upper/lower case, substring
  def stringOperations(): Unit = {
    println("\n--- (a) Basic String Operations ---")
    val text = "Scala Programming"
    println(s"Original String: '$text'")
    println(s"Length: ${text.length}")
    println(s"Uppercase: ${text.toUpperCase}")
    println(s"Lowercase: ${text.toLowerCase}")
    println(s"Substring (0 to 5): '${text.substring(0, 5)}'")
  }
  // (b) Check whether a given string is a palindrome
  def checkPalindrome(): Unit = {
    println("\n--- (b) Palindrome Check ---")
    val testStr = "Racecar"
    // Convert to lowercase to make it case-insensitive
    val isPalindrome = testStr.toLowerCase == testStr.toLowerCase.reverse
    
    println(s"String: '$testStr'")
    if (isPalindrome) println("Result: It is a palindrome.")
    else println("Result: It is not a palindrome.")
  }
  // (c) Count vowels and consonants in a string
  def countVowelsConsonants(): Unit = {
    println("\n--- (c) Vowels and Consonants Count ---")
    val sentence = "Hello Scala World"
    
    val vowelsCount = sentence.toLowerCase.count(c => "aeiou".contains(c))
    val consonantsCount = sentence.toLowerCase.count(c => c.isLetter && !"aeiou".contains(c))
    
    println(s"String: '$sentence'")
    println(s"Number of Vowels: $vowelsCount")
    println(s"Number of Consonants: $consonantsCount")
  }
  // (d) Array of 10 integers: sum, max, min, average
  def arrayBasicOperations(): Unit = {
    println("\n--- (d) Array Sum, Max, Min, Average ---")
    val numbers = Array(15, 22, 8, 42, 16, 50, 4, 9, 33, 11)
    
    val sum = numbers.sum
    val max = numbers.max
    val min = numbers.min
    val avg = sum.toDouble / numbers.length
    
    println(s"Array elements: ${numbers.mkString(", ")}")
    println(s"Sum: $sum")
    println(s"Maximum: $max")
    println(s"Minimum: $min")
    println(s"Average: $avg")
  }
  // (e) Reverse and sort array without modifying original
  def arrayReverseSortAccess(): Unit = {
    println("\n--- (e) Reverse, Sort and Access ---")
    val originalArray = Array(5, 2, 8, 1, 9)
    
    // .reverse and .sorted create new arrays, leaving original untouched
    val reversedArray = originalArray.reverse
    val sortedArray = originalArray.sorted
    
    println(s"Original Array: ${originalArray.mkString(", ")}")
    println(s"Reversed Array: ${reversedArray.mkString(", ")}")
    println(s"Sorted Array:   ${sortedArray.mkString(", ")}")
    
    // Accessing elements by index
    println(s"Element at index 0: ${originalArray(0)}")
    println(s"Element at index 3: ${originalArray(3)}")
  }
  // (f) 2D Array (3x3 Matrix), print rows, diagonal sum
  def matrixOperations(): Unit = {
    println("\n--- (f) 3x3 Matrix and Diagonal Sum ---")
    // Creating a 3x3 matrix
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    
    println("Matrix row by row:")
    for (row <- matrix) {
      println(row.mkString(" "))
    }
    
    // Calculate primary diagonal sum (where row index == col index)
    var diagonalSum = 0
    for (i <- matrix.indices) {
      diagonalSum += matrix(i)(i)
    }
    
    println(s"Sum of primary diagonal elements (1 + 5 + 9): $diagonalSum")
  }
  // (g) Linear Search
  def linearSearch(): Unit = {
    println("\n--- (g) Linear Search ---")
    val arr = Array(10, 25, 30, 45, 50)
    val target = 30
    
    println(s"Array: ${arr.mkString(", ")}")
    println(s"Searching for: $target")
    
    // Implementing basic linear search manually
    var foundIndex = -1
    for (i <- arr.indices) {
      if (arr(i) == target) {
        foundIndex = i
      }
    }
    
    if (foundIndex != -1) {
      println(s"Element $target found at index $foundIndex.")
    } else {
      println(s"Element $target not found in the array.")
    }
  }
}