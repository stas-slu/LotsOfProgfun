object SimpleObject{
  val param1 : Int = 10
  var param2 : String = "Yes"

  def method1 = "Method 1"

  def sum(a:Int, b:Int) = a + b
}
object Main {

  def main(args: Array[String]) = {

    println(SimpleObject.param1)

    println(SimpleObject.param2)

    //SimpleObject.param1 = 11
    SimpleObject.param2 = "No"

    println(SimpleObject.param2)

    println(SimpleObject.method1)

    println(SimpleObject.sum(10, 15))

  }

}