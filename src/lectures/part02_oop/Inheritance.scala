package lectures.part02_oop

import lectures.part02_oop.Objects.Person

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "Wild"
    def eat = println("nomnom")
  }


  // Single class inheritance
  // Inherits only non-private methods and attributes
  class Cat extends Animal {

    def crunch = {
      eat
      println("crunch crunch")
    }

  }

  val cat = new Cat
  cat.crunch

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  // overriding fields from super class using the constructor
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "Domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution
  // polymorphism
  val unknownAnimal: Animal = new Dog("K9")

  // method calls always go the the most override implementation
  unknownAnimal.eat

  // super


  // prevent overrides
  // 1 - use final
  // 2 - use final on the entire class
  // 3 - seal the class = extend in THIS FILE. Prevent extension in other files.

}
