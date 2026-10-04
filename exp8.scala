// ==========================================
// (a) Inheritance and Overriding
// ==========================================
class Person(val name: String) {
  def describe(): String = s"My name is $name, and I am a Person."
}

class Teacher(name: String, val subject: String) extends Person(name) {
  // Overriding the describe method from the base class
  override def describe(): String = s"My name is $name, and I teach $subject."
}

// ==========================================
// (b) Abstract Classes and Implementations
// ==========================================
abstract class Shape {
  def area(): Double
  def perimeter(): Double
}

class Circle(radius: Double) extends Shape {
  override def area(): Double = math.Pi * radius * radius
  override def perimeter(): Double = 2 * math.Pi * radius
}

class Rectangle(width: Double, height: Double) extends Shape {
  override def area(): Double = width * height
  override def perimeter(): Double = 2 * (width + height)
}

class Triangle(a: Double, b: Double, c: Double) extends Shape {
  override def perimeter(): Double = a + b + c
  override def area(): Double = {
    val s = perimeter() / 2
    // Heron's formula for the area of a triangle
    math.sqrt(s * (s - a) * (s - b) * (s - c)) 
  }
}

// ==========================================
// (d) Trait with Abstract and Concrete Methods
// ==========================================
trait Logger {
  def log(msg: String): Unit // Abstract method
  
  def info(msg: String): Unit = { // Concrete method
    println(s"[INFO]: $msg") 
  } 
}

// Mixing trait using 'extends'
class Database extends Logger {
  override def log(msg: String): Unit = println(s"[DB LOG]: $msg")
}

class FileSystem

// Mixing trait using 'extends' and 'with'
class SecureFileSystem extends FileSystem with Logger {
  override def log(msg: String): Unit = println(s"[SECURE FS LOG]: $msg")
}

// ==========================================
// (e) Multiple Trait Inheritance and Linearization
// ==========================================
trait Root { 
  def trace(): Unit = println("Root") 
}
trait NodeA extends Root { 
  override def trace(): Unit = { print("NodeA -> "); super.trace() } 
}
trait NodeB extends Root { 
  override def trace(): Unit = { print("NodeB -> "); super.trace() } 
}

// Linearization order goes from right to left
class MultiInheritClass extends NodeA with NodeB {
  override def trace(): Unit = { print("MultiInheritClass -> "); super.trace() }
}

// (f) Sealed Trait and Case Classes
sealed trait PaymentMethod
case class CreditCard(number: String) extends PaymentMethod
case class PayPal(email: String) extends PaymentMethod
case object Cash extends PaymentMethod

object Exp8 {
  def processPayment(method: PaymentMethod): Unit = method match {
    case CreditCard(num) => println(s"Processing credit card ending in ${num.takeRight(4)}")
    case PayPal(email)   => println(s"Processing PayPal for $email")
    case Cash            => println("Processing cash payment")
  }
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 8 ==========")
    println("\n--- (a) Inheritance and Overriding ---")
    val person = new Person("Alice")
    val teacher = new Teacher("Bob", "Computer Science")
    println(person.describe())
    println(teacher.describe())
    println("\n--- (b) Abstract Classes and Implementations ---")
    val c = new Circle(5.0)
    val r = new Rectangle(4.0, 5.0)
    val t = new Triangle(3.0, 4.0, 5.0)
    println("Created a Circle, a Rectangle, and a Triangle.")
    println("\n--- (c) Runtime Polymorphism ---")
    val shapes: List[Shape] = List(c, r, t)
    shapes.foreach { shape =>
      println(f"${shape.getClass.getSimpleName} Area: ${shape.area()}%.2f")
    }
    println("\n--- (d) Traits and Mixins ---")
    val db = new Database()
    db.info("Database starting up...") // Concrete method
    db.log("Connected to local database.") // Implemented abstract method
    val fs = new SecureFileSystem()
    fs.info("File system initializing...")
    fs.log("Mounting secure volume.")

    println("\n--- (e) Multiple Trait Inheritance & Linearization ---")
    val linearizedObj = new MultiInheritClass()
    println("Linearization order resolves from right to left for traits (MultiInheritClass -> NodeB -> NodeA -> Root):")
    linearizedObj.trace()
    println("\n--- (f) Sealed Traits and Case Classes ---")
    processPayment(CreditCard("1111-2222-3333-4444"))
    processPayment(PayPal("student@university.edu"))
    processPayment(Cash)
  }
}