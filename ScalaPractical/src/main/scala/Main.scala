package org.scala.practical

object Main {
  def hello(name: Option[String]): Unit = {
    for (s <- name) {
      println(s"Hello $s")
    }
  }

  def main(args: Array[String]): Unit = {

    hello(Some("Tran Duong"))

    println(transformArray(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))

    val a1 = Array(1, 2, 3, 4, 5, 6)

    val a2 = for (i <- a1; if i % 2 != 0) yield i

    println(a2.length)

    var x = new Box(1);

    x.update(i => i * 2)

    x.printMsg()
  }

  def fizzBuzz(): Unit = {
    for (i <- Range(0, 101)) {
      if (i % 3 == 0 && i % 5 == 0) {
        println("FizzBuzz")
      } else if (i % 3 == 0) {
        println("Fizz")
      } else if (i % 5 == 0) {
        println("Buzz")
      } else {
        println(i)
      }
    }
  }

  def transformArray(arr: Array[Int]): Array[Int] = {
    val a2 = for (i <- arr) yield i * i
    a2
  }
}
