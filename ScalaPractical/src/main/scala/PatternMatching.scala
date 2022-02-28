package org.scala.practical

object PatternMatching {
  def main(args: Array[String]): Unit = {
    println(daysOfWeek(1))
  }

  def daysOfWeek(day: Int): String = {
    day match {
      case 1 => "Mon"
      case 2 => "Tue"
      case 3 => "Wed"
      case _ => "Unknown"
    }
  }
}
