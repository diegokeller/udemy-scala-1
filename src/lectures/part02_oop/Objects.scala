package lectures.part02_oop

object Objects extends App {

  // Scala does not have class level functionality (static)

  // Objects cannot receive parameters
  object Person {
    // "static" - class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method. Creates instances of Person
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance level functionality
  }

  // Class and Object Person are COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val m2 = Person
  val j2 = Person
  println(m2 == j2)

  val bobbie = Person.apply(mary, john)
  val b2 = Person(mary, john)

  // Scala Application = Scala Object
  // def main(args: Array[String]): Unit
}
