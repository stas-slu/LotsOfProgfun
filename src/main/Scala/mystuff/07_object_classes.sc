//based on this:
//http://www.javacodegeeks.com/2011/10/scala-tutorial-objects-classes.html

//we can create new persons, using Person class
val johnSmith = new Person("John", "Smith", 37, "linguist")
val janeDoe = new Person("Jane", "Doe", 34, "computer scientist")
val johnDoe = new Person("John", "Doe", 43, "philosopher")
val johnBrown = new Person("John", "Brown", 28, "mathematician")

//they all can be pun in List
val people = List(johnSmith, janeDoe, johnDoe, johnBrown)

//different functional operations can applied on them
//map
people.map(person => person.firstName)
people.map(person => person.age)
people.map(person => person.age).sum/people.length.toDouble
def addsOne(i: Int): Int = i + 1
people.map(person => addsOne(person.age))
//sort
val ageSortedPeople = people.sortBy(_.age)
ageSortedPeople.map(person => person.fullName + ":" + person.age)
//groupBy
val groupByPeople: Map[String, List[Person]] = people.groupBy(person => person.firstName)

//we can create standalone object!
object ThomYorke extends Person("Thom", "Yorke", 43, "musician")
ThomYorke.greet(true)

//Classes can be extended and Traits can be used
class Linguist (
                 firstName: String,
                 lastName: String, //NO VAL means it can't be accessible externally!
                 age: Int,
                 val speciality: String,
                 val favoriteLanguage: String
                 ) extends Person(firstName, lastName, age, "linguist") with Worker {

  def workGreeting =
    "As a " + occupation + ", I am a " + speciality + " who likes to study the language " + favoriteLanguage + "."
}

trait Worker {
  def workGreeting: String
}

//Let's create additional class, now with different field favoriteProgrammingLanguage VS favoriteLanguage in Linguist
class ComputerScientist (
                          firstName: String,
                          lastName: String,
                          age: Int,
                          val speciality: String,
                          favoriteProgrammingLanguage: String
                          ) extends Person(firstName, lastName, age, "computer scientist") with Worker {

  def workGreeting =
    "As a " + occupation + ", I work on " + speciality + ". Much of my code is written in " + favoriteProgrammingLanguage + "."
}
//and create two vals (remember - ComputerScientist and Linguist are diffrenet!)
val andrewMcCallum = new ComputerScientist("Andrew", "McCallum", 44, "machine learning", "Scala")
val noamChomsky = new Linguist("Noam", "Chomsky", 83, "syntactician", "English")

//and put them into list. There type will be [Worker with Person]! the most specific type that is valid for all elements of the list
val professors: List[Worker with Person] = List(noamChomsky, andrewMcCallum)
//we will have methods that appear only in Worker and List
professors.map(prof => prof.fullName)
professors.map(prof => prof.workGreeting)
professors.map(prof => prof.greet(true))

//And, we can use Scala's pattern matching to decide what to do in this situation of heterogenous objects
professors.foreach { prof =>
  prof match {
    case x: Person with Worker => println(x.fullName + ": " + x.workGreeting)
    case x: Person => println(x.fullName + ": " + x.greet(true))
    case x: Worker => println("Anonymous:" + x.workGreeting)
  }
}

//The apply function
/*Scala provides a simple but incredibly nice feature: if you define an apply function in a class or object,
you don’t actually need to write “apply” in order to use it. As an example, the following object adds one to
an argument supplied to its apply method.*/
object AddOne {
  def apply (x: Int): Int = x + 1
}
//so you can do:
AddOne.apply(3)
//and also:
AddOne(3)

//so, you can do cool stuff with it:
class AddN (amountToAdd: Int) {
  def apply (x: Int): Int = x + amountToAdd
}

val add2 = new AddN(2)
add2(5) //result will be 7

val add42 = new AddN(42)

add42(8) //result will be 50


/*SOME STUFF TO IMPLEMENT IN THE END FOR THE EXAPLES*/

object JohnSmith {
  val firstName = "John"
  val lastName = "Smith"

  def fullName: String = firstName + " " + lastName
}

object JaneDoe {
  val firstName = "Jane"
  val lastName = "Doe"

  def fullName: String = firstName + " " + lastName
}

class Person (
               val firstName: String,
               val lastName: String,
               val age: Int,
               val occupation: String
               ) {

  def fullName: String = firstName + " " + lastName

  def greet (formal: Boolean): String = {
    if (formal)
      "Hello, my name is " + fullName + ". I'm a " + occupation + "."
    else
      "Hi, I'm " + firstName + "!"
  }
}
