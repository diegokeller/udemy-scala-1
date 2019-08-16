package lectures.part01_basics

import java.security.KeyStore.TrustedCertificateEntry

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Diego", 10))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction) // You can call a function without ()

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  // Instead of Loops, use recursion

  // If a function is recursive, the return type is required, otherwise it can be optional
  // But its recommended to always provide the return type

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Oba!!!")

  // Code blocks can have functions
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  println(aBigFunction(5))

  // =============================
  // Exercises
  // =============================

  // 1. A greeting function for kids with name and age => "Hi, my name is NAME and I am AGE years old"

  def greeting(name: String, age: Int): Unit = {
    println(s"Hi, my name is ${name} and I am ${age} years old.")
  }

  greeting("Marcus", 12)

  // 2. Factorial functional 5!

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(5))

  // 3. A Fibonacci function 1 1, subsequent numbers are the sum of the previous two numbers

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8))

  // 4. Tests if a number is prime.
  def prime(n: Int): Boolean = {

    def divisible(num: Int, den: Int): Int = {
      if (num % den == 0) 1 else 0
    }

    def countDivisors(number: Int, divisor: Int): Int = {
      if (divisor == 0) 0
      else divisible(number, divisor) + countDivisors(number, divisor - 1)
    }

    val divisors = countDivisors(n, n)

    println(s"It has ${divisors} divisors")

    divisors > 0 && divisors <= 2

  }

  println(prime(2003))

  // Implementation from course

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else (n % t) != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(2003))
}
