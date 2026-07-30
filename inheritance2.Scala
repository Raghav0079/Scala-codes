class BankDetails(private var balance: Double) {
  def getBalance: Double = balance
}

abstract class PaymentProcess {
  def paymentProcess(amount: Double): Unit
}

class Card extends PaymentProcess {
  override def paymentProcess(amount: Double): Unit = {
    println(s"payment processed through card of amount $amount")
  }
}

class UPI extends PaymentProcess {
  override def paymentProcess(amount: Double): Unit = {
    println(s"payment processed through UPI of amount $amount")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val account = new BankDetails(1000.0)
    println(s"Current Balance: ${account.getBalance}")

    val payments: List[PaymentProcess] = List(new Card(), new UPI())
    for (payment <- payments) {
      payment.paymentProcess(250.0)
    }
  }
}