package lectures.part02_oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, age: Int = 0) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : Unit = println(s"My name is $name, I am $age years old and my favourite movie is '$favouriteMovie'.")

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def learns(subject: String): Unit = println(s"$name learns $subject")

    def learnsScala(): Unit = learns("Scala")

    def apply(times: Int): Unit = println(s"$name watched '$favouriteMovie' $times times.")

  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))

  println( mary likes "Inception")
  // infix notation - operator notation (syntactic sugar)
  // works only for methods with a single parameter

  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")

  println(mary + tom) //+ is the name of the method
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATOR ARE METHODS
  // + - * /

  // Akka actors have ! and ? as methods

  // Prefix Notations
  // ----------------
  val x = -1
  val y = 1.unary_-
  println(x)
  println(y)

  // unary_ prefix works only with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // Postfix Notations
  // -----------------

  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  // -----

  println(mary.apply())
  println(mary()) // equivalent to the above

  // Exercises
  // ----------

  /*

    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"

    2.  Add an age to the Person class
        Add a unary + operator => new person with age + 1
        +mary => mary with the age incrementer

    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala"
        Use it in postfix notation

    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"

   */

  // 1
  val maryRocks = mary + "The Rockstar"
  !maryRocks

  // 2
  val mary2 = +(+(+mary))
  !mary2

  // 3
  mary learns "Scala"
  mary learnsScala

  // 4
  mary(4)
}
