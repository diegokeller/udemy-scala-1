package lectures.part02_oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String // no value - abstract
    def eat: Unit // no implementation - abstract
  }

  class Dog extends Animal {
    override val creatureType: String = "Wild"
    def eat: Unit = println("crunch, crunch") // override word is not required
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // non abstract
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = print("nom nom")

    override def eat(animal: Animal): Unit = println(s"I am a $creatureType and I am eating a ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // both can have abstract and non abstract members
  // 1 - traits do not have constructor parameters
  // 2 - can only extend one class, but can use multiple traits
  // 3 - traits are behaviour. Abstract class are "things"
}
