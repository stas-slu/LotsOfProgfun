
case class Person(name: String)
case class NewPerson(name: String, citizenship: String)

def convert(person: Person) = NewPerson(person.name, "ISR")

val persons: Seq[Person] = Seq(Person("simon"))
val maybePersons1: Option[Seq[Person]] = Option(null)
val maybePersons2: Option[Seq[Person]] = Option(persons)

val convertedPersons1 = maybePersons1.map(_.map(convert))
val convertedPersons2 = maybePersons1.map(_.map(convert)).getOrElse(Nil)
val convertedPersons3 = maybePersons1.map(_.map(convert)).orElse(maybePersons2)

