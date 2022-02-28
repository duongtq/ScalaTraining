package org.scala.practical

object ClassAndSubclass {
  class Robot(val name: String = "Unknown") {
    def welcome(n: String): String = s"Hello $n! My name is $name"
  }

  class ItalianRobot(name: String) extends Robot(name) {
    override def welcome(n: String): String = s"Benvenuto $n! Il mio nome e' $name"
  }

  class EnglishRobot(name: String, country: String) extends Robot(name) {
    override def welcome(n: String): String = s"Welcome $n, I am $name from the country of $country!"
  }

  class Car(val brand: String, val name: String) {

  }

  class Computer(var brand: String,var name: String) {

    // A secondary constructor
    def this() {
      this("", "")
    }

    // Another constructor
    def getBrand: String = {
      this.brand
    }

    def getName: String = {
      this.name
    }

    def setBrand(brand: String): Unit = {
      this.brand = brand
    }

    def setName(name: String): Unit = {
      this.name = name
    }

  }

  def main(args: Array[String]): Unit = {
    val bmwZ4 = new Car("BMW", "Z4")
    println(bmwZ4.name)
    println(bmwZ4.brand)

    val macbook = new Computer("Apple", "Macbook")
    val lenovoLegion = new Computer();

  }
}
