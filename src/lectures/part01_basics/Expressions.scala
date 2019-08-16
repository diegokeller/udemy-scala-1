package lectures.part01_basics

object Expressions extends App {

  // =============================
  // Operators
  // =============================

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)

  // >>> right shift with zero extension

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // =============================
  // Instructions vs Expressions
  // =============================

  // Instructions - Something that we tell the computer to do
  // Expressions - Evaluate a value

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  // The IF expression gives back the value
  println(if(aCondition) 10 else 9)

  // The IF in scala is an Expression not a Instruction

  var i = 0
  val aWhile = while(i < 10) {
    println(i)
    i += 1
  }

  // Never write this again!!!!
  // These kind of loop controls are a imperative syntax
  // Scala forces everything to be an expression

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // While and If return Unit
  // We call them Side Effects
  // Remaining from imperative languages
  // println(), while, reassigning

  // Code block
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }

  // Code block is an EXPRESSION
  // The value of the code block is the result of the last expression
  println(aCodeBlock)

  // What is declared inside the code block is only visible inside the code block
  // val error = y

  // =============================
  // Exercises
  // =============================

  // 1. Difference between "hello world" and println("hello world")
  // The first returns a String, the second a Unit

  // 2.

  val someValue = {
    2 < 3
  }

  println(someValue + " -> This should be a Boolean True")

  // 3.
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  println(someOtherValue + " -> This should be 42")
}
