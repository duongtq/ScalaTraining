package org.scala.practical

import scala.collection.mutable.ArrayBuffer

object GradingStudents {


  def main(args: Array[String]): Unit = {
    val initialGrades = Array(84, 94, 21, 18, 100, 0)

    val finalGrades = gradingStudents(initialGrades)

    println(finalGrades.mkString("[", ", ", "]"))
  }

  def gradingStudents(grades: Array[Int]): Array[Int] = {
    val map: Map[Int, Array[Int]] = Map(
      4 -> Array(45, 50),
      5 -> Array(55, 60),
      6 -> Array(65, 70),
      7 -> Array(75, 80),
      8 -> Array(85, 90),
      9 -> Array(95, 100)
    )

    val finalGrades: ArrayBuffer[Int] = ArrayBuffer()

    for (i <- grades) {
      if (i == 100) {
        finalGrades += i
      } else if (i < 40) {
        if (40 - i < 3) {
          finalGrades += 40
        } else {
          finalGrades += i
        }
      } else {
        val decimalPart: Int = i / 10;
        val bounds = map(decimalPart) // => array of bounds

        val lower = bounds(0)
        val upper = bounds(1)

        if (i < lower) {
          if (lower - i < 3) {
            finalGrades += lower
          } else {
            finalGrades += i
          }
        }

        if (i >= lower && i <= upper) {
          if (upper - i < 3) {
            finalGrades += upper
          } else {
            finalGrades += i
          }
        }
      }
    }

    finalGrades.toArray
  }
}
