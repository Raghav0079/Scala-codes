object Main {

  def wordCount(words: List[String]): Map[String, Int] = {
    // 1. Group words by the word itself: Map("apple" -> List("apple", "apple"), "banana" -> List("banana"))
    // 2. Count the size of each grouped list
    words.groupBy(identity).view.mapValues(_.size).toMap
  }

  def main(args: Array[String]): Unit = {
    val sentence = List("scala", "is", "fun", "and", "scala", "is", "fast")

    val counts = wordCount(sentence)

    println(counts)
  }
}