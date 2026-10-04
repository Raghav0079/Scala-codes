import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
object exp5 {
  def main(args: Array[String]): Unit = {
    println("========== EXPERIMENT 5 ==========")
    listOperations()
    mutableBufferOperations()
    setOperations()
    mapOperations()
    mapSafeAccess()
    tupleAndZip()
    mutableVsImmutable()
  }
  // (a) Immutable List operations
  def listOperations(): Unit = {
    println("\n--- (a) Immutable List Operations ---")
    val list1 = List(10, 20, 30, 40, 50)
    val list2 = List(60, 70)

    println(s"Original List1: $list1")
    println(s"Head (first element): ${list1.head}")
    println(s"Tail (all but first): ${list1.tail}")
    println(s"Take (first 2 elements): ${list1.take(2)}")
    println(s"Drop (skip first 2 elements): ${list1.drop(2)}")
    println(s"Reverse: ${list1.reverse}")
    
    // Appending and Prepending
    println(s"Append element (:+) -> ${list1 :+ 99}")
    println(s"Prepend element (+:) -> ${0 +: list1}")
    
    // Concatenation
    println(s"Concatenate lists (:::) -> ${list1 ::: list2}")
  }
  // (b) Mutable ListBuffer operations
  def mutableBufferOperations(): Unit = {
    println("\n--- (b) ListBuffer (Mutable) Operations ---")
    val buffer = ListBuffer("Apple", "Banana")
    println(s"Initial Buffer: $buffer")

    buffer += "Cherry"    // Add
    println(s"After adding: $buffer")

    buffer(1) = "Blueberry" // Update by index
    println(s"After updating index 1: $buffer")

    buffer -= "Apple"     // Remove specific element
    // Or buffer.remove(0) to remove by index
    println(s"After removing 'Apple': $buffer")
  }
  // (c) Set operations (Union, Intersection, Difference)
  def setOperations(): Unit = {
    println("\n--- (c) Set Operations ---")
    // Note how duplicate '2's and '3's are automatically removed
    val set1 = Set(1, 2, 2, 3, 3, 4) 
    val set2 = Set(3, 4, 5, 6)

    println(s"Set1 (Notice duplicates removed): $set1")
    println(s"Set2: $set2")
    
    println(s"Union (set1 | set2): ${set1.union(set2)}")
    println(s"Intersection (set1 & set2): ${set1.intersect(set2)}")
    println(s"Difference (set1 &~ set2): ${set1.diff(set2)}")
  }
  // (d) Map operations (Mutable)
  def mapOperations(): Unit = {
    println("\n--- (d) Map Operations (Student Marks) ---")
    // Using scala.collection.mutable.Map for in-place modifications
    val studentMarks = Map("Alice" -> 85, "Bob" -> 78)
    println(s"Initial Map: $studentMarks")

    studentMarks += ("Charlie" -> 92) // Add
    studentMarks("Alice") = 95        // Update (Alice improved her score)
    studentMarks -= "Bob"             // Remove (Bob left the class)
    
    println(s"Look up Charlie's marks: ${studentMarks("Charlie")}")
    
    println("Iterating over the Map:")
    for ((name, mark) <- studentMarks) {
      println(s"  Student: $name, Marks: $mark")
    }
  }
  // (e) Safe Map access using getOrElse and contains
  def mapSafeAccess(): Unit = {
    println("\n--- (e) Safe Map Access ---")
    val studentMarks = Map("Alice" -> 95, "Charlie" -> 92)

    // Using contains
    val searchName = "Bob"
    if (studentMarks.contains(searchName)) {
      println(s"$searchName's marks: ${studentMarks(searchName)}")
    } else {
      println(s"$searchName is not present in the map (checked via 'contains').")
    }

    // Using getOrElse (provides a default value if key is missing)
    val marks = studentMarks.getOrElse("Bob", "N/A (Student not found)")
    println(s"Trying to get Bob's marks using 'getOrElse': $marks")
  }
  // (f) Tuples and Zip
  def tupleAndZip(): Unit = {
    println("\n--- (f) Tuples and Zip ---")
    // Creating a Tuple2
    val student = ("Diana", 99)
    println(s"Tuple elements: Name = ${student._1}, Marks = ${student._2}")

    // Zipping two lists
    val names = List("Eve", "Frank", "Grace")
    val scores = List(88, 76, 91)
    
    // 'zip' combines elements at corresponding indices into tuples
    val zippedList = names.zip(scores) 
    println(s"Zipped List of Tuples: $zippedList")
  }
  // (g) Mutable vs Immutable Comparison
  def mutableVsImmutable(): Unit = {
    println("\n--- (g) Mutable vs Immutable Collections ---")
    
    // Immutable Collection
    val immutableList = List(1, 2)
    val newImmutableList = immutableList :+ 3 
    // The original list cannot be changed; modifying it creates a NEW list.
    println(s"Original Immutable List: $immutableList")
    println(s"New Immutable List (after append): $newImmutableList")

    // Mutable Collection
    val mutableList = ListBuffer(1, 2)
    mutableList += 3
    // Modifying it changes the ACTUAL collection in memory.
    println(s"Mutable ListBuffer (after append): $mutableList")
  }
}