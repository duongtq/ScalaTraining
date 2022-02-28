case class Person(firstName: String, lastName: String, age: Int) {
  def description: String = s"$firstName $lastName is $age years old"
}

// companion object
object Person {
  def filterAdult(personList: List[Person]): List[Person] = {
    personList.filter(_.age >= 18)
  }
}
