
case class Person(name: String, phoneNumber: String)

val kate = Person("Kate", "4567")
// Case classes also get pattern matching for free, see below.

// Pattern matching

val me = Person("George", "1234")

me match { case Person(name, number) => {
  "We matched someone : " + name + ", phone : " + number }}

me match { case Person(name, number) => "Match : " + name; case _ => "Hm..." }

me match { case Person("George", number) => "Match"; case _ => "Hm..." }

me match { case Person("Kate", number) => "Match"; case _ => "Hm..." }

me match { case Person("Kate", _) => "Girl"; case Person("George", _) => "Boy" }

kate match { case Person("Kate", _) => "Girl"; case Person("George", _) => "Boy" }



// Regular expressions
val email = "(.*)@(.*)".r  // Invoking r on String makes it a Regex
val serialKey = """(\d{5})-(\d{5})-(\d{5})-(\d{5})""".r // Using verbatim (multiline) syntax

val matcher = (value: String) => {
  println(value match {
    case email(name, domain) => s"It was an email: $name"
    case serialKey(p1, p2, p3, p4) => s"Serial key: $p1, $p2, $p3, $p4"
    case _ => s"No match on '$value'" // default if no match found
  })
}

matcher("mrbean@pyahoo.com") // => "It was an email: mrbean"
matcher("nope..") // => "No match on 'nope..'"
matcher("52917") // => "No match on '52917'"
matcher("52752-16432-22178-47917") // => "Serial key: 52752, 16432, 22178, 47917"