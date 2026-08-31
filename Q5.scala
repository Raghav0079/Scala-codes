abstract class PaymentMethod {
  def pay(amount: Double): Unit
}

class CreditCard extends PaymentMethod {
  override def pay(amount: Double): Unit = 
    println(f"Paid Rs. ${amount}%.2f using Credit Card. Transaction Successful!")
}

class UPI extends PaymentMethod {
  override def pay(amount: Double): Unit = 
    println(f"Paid Rs. ${amount}%.2f via UPI. Payment Received!")
}

class Cash extends PaymentMethod {
  override def pay(amount: Double): Unit = 
    println(f"Paid Rs. ${amount}%.2f in Cash. Receipt Issued!")
}

object Q5 {
  def processPayment(method: PaymentMethod, amount: Double): Unit = {
    method.pay(amount)
  }

  def main(args: Array[String]): Unit = {
    val card = new CreditCard()
    val upi = new UPI()
    val cash = new Cash()

    processPayment(card, 1200.50)
    processPayment(upi, 450.00)
    processPayment(cash, 2000.00)
  }
}

/*
Sample Output:
Paid Rs. 1200.50 using Credit Card. Transaction Successful!
Paid Rs. 450.00 via UPI. Payment Received!
Paid Rs. 2000.00 in Cash. Receipt Issued!
*/