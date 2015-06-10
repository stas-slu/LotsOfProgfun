object SimpleObject{
  val param1 : Int = 10
  var param2 : String = "Yes"

  def method1 = "Method 1"

  def sum(a:Int, b:Int) = a + b
}
object Main {

  def main(args: Array[String]) = {

    println(s"Print 1: ${SimpleObject.param1}")

    println(s"Print 2: ${SimpleObject.param2}")

    //SimpleObject.param1 = 11
    SimpleObject.param2 = "No"

    println(s"Print 3: ${SimpleObject.param2}")

    println(s"Print 4: ${SimpleObject.method1}")

    println(s"Print 5: ${SimpleObject.sum(10, 15)}")

  }

}