object Problem2 {
  def processNumbers(nums: List[Int], op: Int => Int): List[Int] = {
    nums.map(op)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(2, 3, 4)
    val cubed = processNumbers(numbers, x => x * x * x)
    println(s"Cubed list: $cubed")
  }
}