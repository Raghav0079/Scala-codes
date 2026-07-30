object Loops {
  def main(args: Array[String]): Unit = {
    
    println("For loop from 1 to 50:")
    for (i <- 1 to 50) {   
      println(i)
    }
    
    println("While loop counting up from 1 to 15:")
    var count = 1
    while (count <= 15) { 
      println(count)
      count += 1
    }

    var marks = 35
    if(marks > 33){
      println("pass and promoted to next class")
    }
    else{
      println("fail need to repeat class")
    }
  }
}