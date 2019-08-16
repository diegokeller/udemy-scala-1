package lectures.part01_basics

object StringOps extends App {

  val aString: String = "Hello, I am learning Scala"


  // String functions from Java
  println(aString.charAt(2))
  println(aString.substring(7, 11))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ", "-"))
  println(aString.toLowerCase())
  println(aString.toUpperCase())
  println(aString.length)

  val aNumberString = "45"
  var aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(aString.reverse)
  println(aString.take(2))

  // Scala specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  println(greeting)

  val anotherGreeting = s"Hello! My name is $name and I am turning ${age + 10} years old."
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2
  val myth = f"$name%s can eat $speed%2.2f burguers per minute."
  println(myth)

  // Raw-interpolator
  println("This is a \n new line.")
  println(raw"This is a \n new line.")

  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
