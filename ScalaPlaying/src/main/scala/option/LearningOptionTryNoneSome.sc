val a1 = Option(null)
val a2 = Option("Hello!")
val a3: Option[String] = null

val b1 = Some(null)
val b2 = Some("Hello!")
val b3: Some[String] = null

val a4 = Nil


case class TestObj(intA: Int, stringA: String)
val testObj = TestObj(1, null)
testObj.stringA




