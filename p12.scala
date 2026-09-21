sealed trait Shape

case class Circle(radius : Double) extends Shape
case class Rectangle(w: Double, h: Double) extends Shape
case class Triangle(base: Double, height: Double) extends Shape

object Main{
    def area ( shape : Shape) : Double = shape match {
        case Circle(r)        => Math.PI * r * r
        case Rectangle(w, h)  => w * h
        case Triangle(b, h)   => 0.5 * b * h
    }

    def main( args : Array[String]) : Unit = {
        val c = Circle(5.0)
        val r = Rectangle(4.0, 6.0)
        val t = Triangle(3.0, 8.0)

        println(s"Circle area: ${area(c)}")
        println(s"Rectangle area: ${area(r)}")
        println(s"Triangle area: ${area(t)}")
        
    }

}