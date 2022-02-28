package org.scala.practical

object Collection {
  def main(args: Array[String]): Unit = {
    println(Array(1, 2, 3, 4, 5).product)
    val map = Map("one" -> 1, "two" -> 2, "three" -> 3)
    println(map.contains("two"))
    println(map("two"))
  }

  def fizzBuzz(handleFunction: String => Unit): Unit = {
    for (i <- Range.inclusive(0, 100)) {
      handleFunction (
        if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
        else if (i % 3 == 0) "Fizz"
        else if (i % 5 == 0) "Buzz"
        else i.toString
      )
    }
  }
}
