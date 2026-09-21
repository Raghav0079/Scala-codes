// 1. Immutable Account case class
case class Account(id: String, balance: Double)

object BankService {

  // 2. Deposit: Pure function that returns a new Account with updated balance
  def deposit(acc: Account, amt: Double): Account = {
    acc.copy(balance = acc.balance + amt)
  }

  // 3. Withdraw: Pure function returning Left(error) or Right(new Account)
  def withdraw(acc: Account, amt: Double): Either[String, Account] = {
    if (amt > acc.balance) Left(s"Insufficient funds! Current balance: $$${acc.balance}, requested: $$${amt}")
    else Right(acc.copy(balance = acc.balance - amt))
  }
}

// Runnable test program
object Main {
  def main(args: Array[String]): Unit = {
    val initialAcc = Account("ACC-101", 100.0)

    // Deposit $50
    val accAfterDeposit = BankService.deposit(initialAcc, 50.0)
    println(s"After deposit: $accAfterDeposit")

    // Successful withdrawal of $30
    BankService.withdraw(accAfterDeposit, 30.0) match {
      case Right(updatedAcc) => println(s"Successful withdrawal: $updatedAcc")
      case Left(error)       => println(s"Failed: $error")
    }

    // Failed withdrawal of $200 (Insufficient funds)
    BankService.withdraw(accAfterDeposit, 200.0) match {
      case Right(updatedAcc) => println(s"Successful withdrawal: $updatedAcc")
      case Left(error)       => println(s"Failed: $error")
    }
  }
}