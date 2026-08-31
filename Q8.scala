trait Vehicle

case class Car(model: String, seats: Int) extends Vehicle
case class Bike(model: String) extends Vehicle
case class Truck(model: String, capacityTons: Double) extends Vehicle

object Q8 {
  def describeVehicle(v: Vehicle): String = v match {
    case Car(m, s)   => s"Car: $m ($s seats)"
    case Bike(m)     => s"Bike: $m"
    case Truck(m, c) => s"Truck: $m ($c tons)"
  }

  def main(args: Array[String]): Unit = {
    println(describeVehicle(Car("Tesla", 5)))
    println(describeVehicle(Bike("Yamaha")))
    println(describeVehicle(Truck("Volvo", 25.5)))
  }
}

/*
Sample Output:
Car: Tesla (5 seats)
Bike: Yamaha
Truck: Volvo (25.5 tons)
*/