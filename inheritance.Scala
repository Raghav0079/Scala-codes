
// 1. create a program for single level inheritance

class Car(var name: String, var gates: Int) {
    def speed(): Unit = println("max speed of car")
}

class Sedan(name: String, gates: Int, var model: String) extends Car(name, gates)

object Main {
    def main(args: Array[String]): Unit = {
        val s = new Sedan("Toyota", 4, "Camry")
        println(s"Name: ${s.name}, Gates: ${s.gates}, Model: ${s.model}")
        s.speed()
    }
}
