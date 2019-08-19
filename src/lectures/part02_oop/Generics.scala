package lectures.part02_oop

object Generics extends App {

  class MyList[+A] {

    // use the type A inside the class definition

    def add[B >: A](element: B): MyList[B] = ???


  }

  // Multiple type parameters
  class MyMap[Key, Value] {


  }

  // Traits can also be type parameterized

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Objects cannot be type parameterized
  object MyList {

    def empty[A]: MyList[A] = ???

  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. No = INVARIANCE
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] - DON'T COMPILE
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell NO! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car) // Compile error. Car is not subclass of Animal

  // expand MyList to be generic
}
