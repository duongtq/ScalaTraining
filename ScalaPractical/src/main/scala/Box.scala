package org.scala.practical

class Box(var x: Int) {
  def update(f: Int => Int): Unit = x = f(x)
  def printMsg(): Unit = {
    println(x)
  }
}
