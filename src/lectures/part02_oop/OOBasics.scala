package lectures.part02_oop

import scala.annotation.tailrec

object OOBasics extends App {

  // Person

  val person = new Person("John", 21)

  println(person.x)
  println(person.age)

  person.greet()
  person.greet("Maria")

  var person2 = new Person("Maria")
  person2.greet()

  println("------------------------------------------------")

  // Writer and Novel
  var saramago = new Writer("Jose", "Saramago", 1950)
  println(saramago.fullName())

  var cegueira = new Novel("Ensaio sobre a cegueira", 1970, saramago)
  println(cegueira.authorAge())

  println(s"Is it written by Saramago? ${cegueira.isWrittenBy(saramago)}")

  var cegueira2 = cegueira.copy(1995)
  println(cegueira2.authorAge())

  println("------------------------------------------------")

  // Counter

  var c1 = new Counter()
  c1.print()
  c1 = c1.increment()
  c1.print
  c1 = c1.increment(10)
  c1.print

  var c2 = c1.decrement().decrement().decrement()
  c2.print()

  println("------------------------------------------------")

}

// Class parameter are not fields
// To make a parameter a field, add "val" to the parameter declaration

// Constructor
class Person(name: String, val age: Int = 0) {

  // Class body
  // Executed every time an instance of this class is created

  // Val declarations here are fields, accessible outside the class
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // Overloading. Methods with the same name but with different signatures
  def greet(): Unit = println(s"Hi! I am $name!")

  // Multiple constructors
  // New constructors can only call another existing constructor
  // Generally used only to define default value to parameters
  // But you can do the same with default values for constructor
  def this(name: String) = this(name, 0)

}

/*
    Novel and Writer
    Writer: first name, surname, year
      - method fullname

    Novel: name, year of release, author
      - authorAge (age of the author at the year of release)
      - isWrittenBy(author)
      - copy (new year of release = new instance of Novel
   */

class Writer(val firstName: String, val surname: String, val year: Int) {

  def fullName(): String = s"$firstName $surname"

}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {

  def authorAge(): Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}

/*
  Counter class
    - receives an int value
    - method current count
    - methods do increment / decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val value: Int = 0) {

  def increment(): Counter = {
    println("Incrementing")
    new Counter(value + 1)
  }

  def decrement(): Counter = {
    println("Decrementing")
    new Counter(value - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment().increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement().decrement(amount - 1)
  }

  def print(): Unit = println(value)

}

