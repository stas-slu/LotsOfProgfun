
// Object oriented features
// Classes can contain nearly any other construct, including other classes,
// functions, methods, objects, case classes, traits etc.
class Dog(br: String) {

  var breed: String = br // Constructor code here

  //A method called bark, returning a String
  def bark: String = { // Values and methods are assumed public
    "Woof, woof!"
  }

  // def chaseAfter(what: String): String  // Abstract methods are simply methods with no body
}

// Case classes are classes that have extra functionality built in. A common
// question for Scala beginners is when to use classes and when to use case
// classes. The line is quite fuzzy, but in general, classes tend to focus on
// encapsulation, polymorphism, and behavior. The values in these classes tend
// to be private, and only methods are exposed. The primary purpose of case
// classes is to hold immutable data. They often have few methods, and the
// methods rarely have side-effects.
case class Person(name: String, phoneNumber: String)

Person("George", "1234") == Person("Kate", "1236")

// Create a new instance. Note cases classes don't need "new"
val george = Person("George", "1234")
val kate = Person("Kate", "4567")
// With case classes, you get a few perks for free, like getters:
george.phoneNumber  // => "1234"

// Easy way to copy
val otherGeorge = george.copy(phoneNumber = "9876")

// And many others. Case classes also get pattern matching for free, see below.

// The "object" keyword creates a type AND a singleton instance of it. It is
// common for Scala classes to have a "companion object", where the per-instance
// behavior is captured in the classes themselves, but behavior related to all
// instance of that class go in objects. The difference is similar to class
// methods vs static methods in other languages. Note that objects and classes
object Dog {
  def allKnownBreeds = List("pitbull", "shepherd", "retriever")
  def createDog(breed: String) = new Dog(breed)
}