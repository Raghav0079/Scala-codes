class BankAccount(private var balance: Double = 0.0) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(f"Deposited Rs. ${amount}%.2f. New Balance: Rs. ${balance}%.2f")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount <= 0) {
      println("Withdrawal amount must be positive.")
    } else if (amount > balance) {
      println(f"Error: Insufficient funds! Attempted to withdraw Rs. ${amount}%.2f, but balance is Rs. ${balance}%.2f.")
    } else {
      balance -= amount
      println(f"Withdrew Rs. ${amount}%.2f. Remaining Balance: Rs. ${balance}%.2f")
    }
  }

  def getBalance(): Double = balance
}

object Q3 {
  def main(args: Array[String]): Unit = {
    val account = new BankAccount()

    account.deposit(500.0)
    account.withdraw(150.0)
    account.withdraw(400.0) // Attempting invalid withdrawal
    println(f"Final Balance: Rs. ${account.getBalance()}%.2f")
  }
}

/*
Sample Output:
Deposited Rs. 500.00. New Balance: Rs. 500.00
Withdrew Rs. 150.00. Remaining Balance: Rs. 350.00
Error: Insufficient funds! Attempted to withdraw Rs. 400.00, but balance is Rs. 350.00.
Final Balance: Rs. 350.00
*/