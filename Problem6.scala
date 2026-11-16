abstract class Vehicle(val brand: String) {
  def maxSpeed(): Int // Abstract method
}

trait Electric {
  def charge(): Unit = println("Charging battery...") // Concrete method
}

class Tesla(brand: String) extends Vehicle(brand) with Electric {
  override def maxSpeed(): Int = 250
}

object Problem6 {
  def main(args: Array[String]): Unit = {
    val car = new Tesla("Tesla Model S")
    car.charge()
    println(s"${car.brand} Top Speed: ${car.maxSpeed()} km/h")
  }
}