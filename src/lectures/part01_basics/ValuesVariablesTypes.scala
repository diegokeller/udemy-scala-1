package lectures.part01_basics

object ValuesVariablesTypes extends App {

  // =============================
  // vals
  // =============================
  // are immutable
  // compiler can infer the type

  val x = 42
  println(x)

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'A'
  val anInt: Int = x
  val aShort: Short = 123
  val aLong: Long = 456L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // =============================
  // variables
  // =============================

  var aVariable: Int = 4
  aVariable = aVariable + 1
  println(aVariable)

}
