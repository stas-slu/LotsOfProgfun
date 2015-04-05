//*************** everything is an object, including a function. Type these in the REPL:

7 // results in res30: Int = 7 (res30 is just a generated var name for the result)

// The next line gives you a function that takes an Int and returns it squared
(x:Int) => x * x


// You can assign this function to an identifier, like this:
val sq = (x:Int) => x * x

/* The above says this

   sq: Int => Int = <function1>

   Which means that this time we gave an explicit name to the value - sq is a
   function that take an Int and returns Int.

   sq can be executed as follows:
*/

sq(10)   // Gives you this: res33: Int = 100.
sq(9)   // Gives you this: res33: Int = 81.


/*Lazy vals.
The difference between them is, that a val is executed when it is defined
whereas a lazy val is executed when it is accessed the first time.
Little known Scala fact: if the initialization of a lazy val throws an exception,
it will attempt to reinitialize the val at next access.*/

val numA = 15
lazy val numB = 13

//Also lazy is useful without cyclic dependencies, as in the following code:

abstract class X1 {
  val x1: String
  println ("x1 is "+x1.length)
}

object Y1 extends X1 {
  val x1 = "Hello"
}
//Y1

//Accessing Y1 will now throw null pointer exception, because x is not yet initialized (superclass
//constructor is first one that gets implicitly called). The following, however, works fine:

abstract class X2 {
  val x2: String
  println("x2 is " + x2.length)
}

object Y2 extends X2{
  lazy val x2 = "Hello"
}
Y2