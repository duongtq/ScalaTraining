package org.scala.practical

import scala.util.{Failure, Success, Try}

object ErrorHandling {
  case class DivideByZero() extends RuntimeException

  def divide(dividend: Int, divisor: Int): Int = {
    if (divisor == 0) {
      throw new DivideByZero
    }
    dividend / divisor
  }

  def divideByZero(a: Int): Any = {
    try {
      divide(1, 0)
    } catch {
      case e: DivideByZero => null
    }
  }

  def main(args: Array[String]): Unit = {
    assert(divideWithTry(10, 1) == Success(10))

    val x = divideWithOption(10, 0);
    println(x)

    val y = divideWithEither(10, 0)
    println(y)
  }

  def divideWithTry(dividend: Int, divisor: Int): Try[Int] = Try(divide(dividend, divisor))

  def divideWithOption(dividend: Int, divisor: Int): Option[Int] = {
    if (divisor == 0) {
      None
    } else
      Some(dividend / divisor)
  }

  def divideWithEither(dividend: Int, divisor: Int): Either[String, Int] = {
    if (divisor == 0) {
      Left("Can't divide by 0")
    } else {
      Right(dividend / divisor)
    }
  }


}
