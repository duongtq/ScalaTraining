import org.scalatest.{WordSpec, Matchers}

class MainSpec extends WordSpec with Matchers{
  "A Person" should {
    "be instantiated with a age and name" in {
      val john = Person(firstName = "John", lastName =  "Smith", age = 42)
      john.firstName should be("John")
      john.lastName should be("Smith")
      john.age should be(42)
    }
    "get a human-readable representation of the person" in {
      val paul = Person(firstName = "Paul", lastName = "Smith", age = 24)
      paul.description should be("Paul Smith is 24 years old")
    }
  }
  "The Person companion object" should {
    val (akira, peter, nick) = (
      Person(firstName = "Akira", lastName = "Tomoe", age = 22),
      Person(firstName = "Peter", lastName = "Osborn", age = 23),
      Person(firstName = "Nick", lastName = "Bentner", age = 15)
    )

    "return a list of adults" in {
      val ref = List(akira, peter, nick)
      Person.filterAdult(ref) should be(List(akira, peter))
    }
    "return a empty list if no adult in the list" in {
      val ref = List(nick)
      Person.filterAdult(ref) should be(List.empty[Person])
    }
  }
}
