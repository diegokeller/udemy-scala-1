package exercises

abstract class MyList[+A] {

  /*

  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) = new list with this element added
  toString = string representation of the list

   */

  def head(): A
  def tail(): MyList[A]
  def isEmpty(): Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String

  def map[B](myTransformer: MyTransformer[A, B]): MyList[B]
  def filter(myPredicate: MyPredicate[A]): MyList[A]
  def flatMap[B](myTransformer: MyTransformer[A, MyList[B]]): MyList[B]

  def ++[B >: A](list: MyList[B]): MyList[B]

  override def toString: String = "[" + printElements + "]"

}

case object Empty extends MyList[Nothing] {

  override def head(): Nothing = throw new NoSuchElementException

  override def tail(): MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](myTransformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def flatMap[B](myTransformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head(): A = h

  override def tail(): MyList[A] = t

  override def isEmpty(): Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if(t.isEmpty())
      " " + h
    else
      h + " " + t.printElements
  }

  override def map[B](myTransformer: MyTransformer[A, B]): MyList[B] = {
    val transformed = myTransformer.transform(head())
    new Cons[B](transformed, tail().map(myTransformer))
  }

  override def filter(myPredicate: MyPredicate[A]): MyList[A] = {
    val element = head()
    val pass = myPredicate.test(element)
    if (pass) new Cons[A](element, tail().filter(myPredicate))
    else tail().filter(myPredicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(head(), tail() ++ list)
  }

  override def flatMap[B](myTransformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    myTransformer.transform(h) ++ t.flatMap(myTransformer)
  }

}

// ============================
// Traits
// ============================

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(element: Int): Boolean = (element % 2) == 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(element: String): Int = element.toInt
}

// ============================
// App
// ============================


object ListTest extends App {
/*
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail().head())

  println(list.add(4).head())
  println(list.isEmpty())
  println(list.toString)
*/

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfIntegers2: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(new EvenPredicate().test(1))
  println(new EvenPredicate().test(2))
  println(new StringToIntTransformer().transform("5"))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  println(listOfIntegers ++ listOfIntegers2).toString

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons[Int](element + 1, Empty))
  }).toString)


  println(listOfIntegers == cloneListOfIntegers)
}


