/*Write a program that declares a val for your name and a var for your age, then prints "Hi, I'm X and I'm Y
years old." Try reassigning the val and observe the compiler error*/

object Main {

    val name = "abc"
    val age = 35

    println(s"Hello, $name")
    println(s"Age: $age")

}