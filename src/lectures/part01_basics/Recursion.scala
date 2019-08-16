package lectures.part01_basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n)
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(5000))

  // When you need loop use TAIL recursion.

  // Exercises
  // 1. Concatenate string n time

  def concatenate(x: String, n: Int): String = {

    @tailrec
    def concatenateHelper(x: String, n: Int, concat: String): String = {
      if (n == 0) concat
      else concatenateHelper(x, n - 1, concat + x)
    }

    concatenateHelper(x, n, "")

  }

  println(concatenate("Ha", 5))



  // 2. Is Prime

  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeUntil(l: Int, prime: Boolean): Boolean = {
      if (!prime) false
      else if (l <= 1) true
      else isPrimeUntil(l - 1, (n % l > 0) && prime)
    }

    isPrimeUntil(n / 2, true)

  }

  println("Is Prime: " + isPrime(629))
  println("Is Prime: " + isPrime(2003))

  // 3. Fibonacci

  def fibonacci(n: Int): Int = {

    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i > n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailrec(3, 1, 1)
  }

  println(fibonacci(8))

}
