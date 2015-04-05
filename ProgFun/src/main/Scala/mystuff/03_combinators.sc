
//*************** Combinators
case class Person(name:String, age:Int)

val sq = (x:Int) => x * x

val setOfNums = Set(1, 3, 7)

setOfNums.map(sq) //multiplying the values in set as in function sent to map (predicate)

val sSquared = setOfNums.map(sq)
sSquared.filter(_ < 10)
sSquared.reduce (_+_)
// The filter function takes a predicate (a function from A -> Boolean) and
// selects all elements which satisfy the predicate
List(1, 2, 3) filter (_ > 2) // List(3)
List(
  Person(name = "Dom", age = 23),
  Person(name = "Bob", age = 30)
).filter(_.age > 25) // List(Person("Bob", 30))


// For comprehensions
//Pretty hard... http://docs.scala-lang.org/tutorials/FAQ/yield.html
//Easier explanation... http://alvinalexander.com/scala/scala-for-loop-yield-examples-yield-tutorial

val example1 = for (i <- 1 to 5) yield i
val example2 = for (i <- 1 to 5) yield i * 2
val example3 = for (i <- 1 to 5) yield i % 2

val arrayOfNums = Array(1, 2, 3, 4, 5) //a: Array[Int] = Array(1, 2, 3, 4, 5)
val example4 = for (e <- arrayOfNums if e > 2) yield e //example4: Array[Int] = Array(3, 4, 5)

for { n <- setOfNums } yield sq(n)
val nSquared2 = for { n <- setOfNums } yield sq(n)
for { n <- nSquared2 if n < 10 } yield n
for { n <- setOfNums; nSquared = n * n if nSquared < 10} yield nSquared
/* NB Those were not for loops. The semantics of a for loop is 'repeat', whereas
   a for-comprehension defines a relationship between two sets of data. */

