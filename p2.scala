object Main {

  def main(args: Array[String]): Unit = {

    val string = "Scala is fun"
    val test = "madam"
    //  Reverse 
    def reverseString(str: String): String = str.reverse

    // Count vowels
    def countVowels(str: String): Int = 
      str.count(char => "aeiouAEIOU".contains(char))

    // Check for palindrome
    def isPalindrome(str: String): Boolean = 
      str.toLowerCase == str.toLowerCase.reverse

    // Output
    println(s"Reversed: '${reverseString(string)}'")
    println(s"Vowel count: ${countVowels(string)}")
    println(s"Is '$string' a palindrome? ${isPalindrome(string)}")
    println(s"Is '$test' a palindrome? ${isPalindrome(test)}")
  }

}