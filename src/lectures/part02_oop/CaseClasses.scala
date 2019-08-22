package lectures.part02_oop

object CaseClasses extends App {

  // equals, hashCode, toString

  case class Person(name: String, age: Int)

  // 1 - Class parameters are promoted to fields
  val jim = new Person("Jim", 30)
  println(jim.name)

  // 2 - toString
  println(jim)

  // 3 - equals and hashCode implemented out of the box OOTB
  val jim2 = new Person("Jim", 30)
  println(jim.equals(jim2))

  // 4 - Copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5 - Companion objects
  val thePerson = Person
  println(thePerson)

  // Calls the apply method - same as the constructor, without the "new"
  val mary = Person("Mary", 23)
  println(mary)

  // 6 - Serializable
  // Akka

  // 7 - Extractor patterns
  // Can be used in pattern matching

  // Case object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  // Exercise
  // Expand MyList to use case classes and case objects

}
