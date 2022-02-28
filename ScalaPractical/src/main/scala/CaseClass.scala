package org.scala.practical

object CaseClass {
  def main(args: Array[String]): Unit = {
    case class Point(x: Int, y: Int)

    val p = Point(1, 2)
    val p1 = Point(1, 2)

    println(p == p1)
  }
}
