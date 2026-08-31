abstract class Employee(val name: String) {
  def calculateSalary(): Double
}

trait Bonus {
  def bonusAmount(): Double = 5000.0 // Fixed bonus
}

class Manager(name: String, val baseSalary: Double) extends Employee(name) with Bonus {
  override def calculateSalary(): Double = {
    baseSalary + bonusAmount()
  }
}

object Q7 {
  def main(args: Array[String]): Unit = {
    val manager = new Manager("Sarah", 75000.0)
    
    println(s"Manager Name: ${manager.name}")
    println(f"Base Salary: Rs. ${manager.baseSalary}%.2f")
    println(f"Bonus: Rs. ${manager.bonusAmount()}%.2f")
    println(f"Total Salary: Rs. ${manager.calculateSalary()}%.2f")
  }
}

/*
Sample Output:
Manager Name: Sarah
Base Salary: Rs. 75000.00
Bonus: Rs. 5000.00
Total Salary: Rs. 80000.00
*/