//*************** Data structures
val a = Array(1, 2, 3, 5, 8, 13)
a(0)
a(3)
//a(21)    // Throws an exception

val myMap = Map("fork" -> "tenedor", "spoon" -> "cuchara", "knife" -> "cuchillo")
myMap("fork")
myMap("spoon")
//myMap("bottle")       // Throws an exception

val safeMap = myMap.withDefaultValue("no lo se")
safeMap("bottle") // default value returned for key that not exist

val setOfNums = Set(1, 3, 7)
setOfNums(0) //0 not in set - false
setOfNums(1) //0 not in set - true
