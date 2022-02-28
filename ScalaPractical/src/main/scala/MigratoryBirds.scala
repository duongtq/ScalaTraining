package org.scala.practical

import scala.io.Source

object MigratoryBirds {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 1, 2, 2, 2, 3, 3, 3)
    val x = migratoryBirds(arr)
    println(x)
  }

  def migratoryBirds(arr: Array[Int]): Int = {
    val set = arr.toSet
    var map: Map[Int, Int] = Map.empty[Int, Int]

    for (i <- set) {
      var count = 0;
      for (j <- arr) {
        if (i == j) {
          count+=1
        }
      }
      map += (i -> count)
    }

    var maxValue = 0

    for (_ -> value <- map) {
      if (maxValue < value) {
        maxValue = value
      }
    }
    map.filter(_._2 == maxValue).minBy(_._1)._1
  }
}
