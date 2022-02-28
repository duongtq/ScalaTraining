package org.scala.practical

object ByNameParameter {
  def main(args: Array[String]): Unit = {
    measureTime(new Array[String](10 * 100 * 100).hashCode())
  }

  def measureTime(f: => Unit): Unit = {
    val start = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    println("Evaluation took " + (end - start) + " milliseconds")
  }
}
