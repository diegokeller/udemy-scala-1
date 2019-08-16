package lectures.part01_basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  def factorial(n: Int): Int = {

    /**
      * Default value for a parameter
      *
      * @param i
      * @param acc Defaults to 1
      * @return
      */
    @tailrec
    def tail(i: Int, acc: Int = 1): Int = {
      if (i > n) acc
      else tail(i + 1, i * acc)
    }

    tail(1)

  }

  println(factorial(5))

  // ==========================================================================

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println(s"Saving picture. Format: ${format}, Width: ${width}, Height: ${height}")

  // Parameters with default values should be at the end of the function definition
  // Or you add default values to all the parameters

  savePicture()
  savePicture("bpm")

  // Or you can use named parameters

  savePicture(width = 500, height = 500)

  // You can even change the order of the parameters

  savePicture(height = 768, width = 1024, format = "gif")
}
