package org.scala.practical

import os.Path

object FileAndDirectory {
  def main(args: Array[String]): Unit = {

    val biggestFiles: IndexedSeq[(Long, Path)] = os.walk(os.pwd)
      .filter(os.isFile)
      .map(p => (os.size(p), p))
      .sortBy(-_._1)
      .take(5)

    for ((size, path) <- biggestFiles) {
      println(s"${path.toString()} - $size")
    }
  }
}
