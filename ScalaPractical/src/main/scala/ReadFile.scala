package org.scala.practical

import scala.io.Source

object ReadFile {
  def main(args: Array[String]): Unit = {
    val fileName = "/Users/MaiSon/SOFTWARE_ENGINEERING/LearnScala/ScalaPractical/src/main/scala/GradingStudents.scala";
    val buffer = Source.fromFile(fileName)
    for (line <- buffer.getLines()) {
      println(line)
    }
    buffer.close()
  }
}
