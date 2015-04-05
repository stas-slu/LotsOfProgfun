//*************** Tuples
val a = Array(1, 2, 3, 5, 8, 13)

(1, 2)

(4, 3, 2)

(1, 2, "three")

(a, 2, "three")

//It actually a syntatic sugar for:
val tup2 = new Tuple2(1, 2)
val tup3 = new Tuple3(a, 2, "three")

// Why have this?
val divideInts = (x:Int, y:Int) => (x / y, x % y)

divideInts(10,3) // The function divideInts gives you the result and the remainder
// To access the elements of a tuple, use _._n where n is the 1-based index of
// the element
val d = divideInts(10,3)
d._1
d._2
