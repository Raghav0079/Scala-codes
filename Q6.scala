trait Printable {
  def printDetails(): Unit
}

trait Discountable {
  def applyDiscount(discountPercent: Double): Double
}

class Product(val name: String, val price: Double) extends Printable with Discountable {
  
  override def printDetails(): Unit = {
    println(s"Product Name: $name | Price: Rs. $price")
  }

  override def applyDiscount(discountPercent: Double): Double = {
    price - (price * discountPercent / 100.0)
  }
}

object Q6 {
  def main(args: Array[String]): Unit = {
    val laptop = new Product("Laptop", 55000.00)

    laptop.printDetails()
    val discountedPrice = laptop.applyDiscount(10.0) // 10% discount
    println(f"Price after 10%% discount: Rs. ${discountedPrice}%.2f")
  }
}

/*
Sample Output:
Product Name: Laptop | Price: Rs. 55000.0
Price after 10% discount: Rs. 49500.00
*/