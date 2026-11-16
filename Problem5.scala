case class Employee(id: Int, role: String, salary: Double)

object Employee {
  // Factory apply method in Companion Object
  def apply(id: Int, role: String): Employee = new Employee(id, role, 50000.0)
}

object Problem5 {
  def calculateBonus(emp: Employee): Double = emp match {
    case Employee(_, "Manager", sal)                  => sal * 0.20
    case Employee(_, "Developer", sal) if sal > 60000 => sal * 0.15
    case Employee(_, _, sal)                          => sal * 0.10
  }

  def main(args: Array[String]): Unit = {
    val e1 = Employee(101, "Manager")            // Calls companion object apply()
    val e2 = Employee(102, "Developer", 70000.0) // Calls default case class apply()
    val e3 = Employee(103, "Tester", 40000.0)

    println(s"${e1.role} Bonus: ${calculateBonus(e1)}")
    println(s"${e2.role} Bonus: ${calculateBonus(e2)}")
    println(s"${e3.role} Bonus: ${calculateBonus(e3)}")
  }
}