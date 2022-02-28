package org.scala.practical

object Application {
  def main(args: Array[String]): Unit = {
    val points: Array[Point] = Array(new Point2D(1, 2), new Point3D(1, 2, 3))

    for (p <- points) {
      println(p.hypotenuse)
    }
  }

  trait Point {
    def hypotenuse: Double
  }

  class Point2D(x: Double, y: Double) extends Point {
    override def hypotenuse: Double = math.sqrt(x * x + y * y)
  }

  class Point3D(x: Double, y: Double, z: Double) extends Point {
    override def hypotenuse: Double = math.sqrt(x * x + y * y + z * z)
  }

  // flexible FizzBuzz
  def flexibleFizzBuzz(handleLine: String => Unit): Unit = {
    for (i <- Range.inclusive(0, 100)) {
      handleLine(
        if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
        else if (i % 3 == 0) "Fizz"
        else if (i % 5 == 0) "Buzz"
        else i.toString
      )
    }
  }
}
