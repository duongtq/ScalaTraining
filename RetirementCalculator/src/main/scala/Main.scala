object Main extends App {
  val persons = List(
    Person(firstName = "Akira", lastName = "Tomoe", age = 22),
    Person(firstName = "Peter", lastName = "Osborn", age = 23),
    Person(firstName = "Nick", lastName = "Bentner", age = 15)
  )
  val adults = Person.filterAdult(persons)
  println(s"The adults are ${adults.mkString("[", ", ", "]")}")
}
