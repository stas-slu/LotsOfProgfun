package scalaswing

import scala.swing.event.EditDone
import swing._

object Converter extends SimpleSwingApplication {
  def newField = new TextField {
    text = "0"
    columns = 5
  }
  val celsius = newField
  val fahrenheit = newField
  def top = new MainFrame {
    title = "Convert Celsius / Fahrenheit"
    contents = new FlowPanel(celsius, new Label(" Celsius = "),
      fahrenheit, new Label(" Fahrenheit"))
  }

  listenTo(fahrenheit, celsius)
  reactions += {
    case EditDone(`fahrenheit`) =>
      val f = Integer.parseInt(fahrenheit.text)
      val c = (f - 32) * 5 / 9
      println(s"fahrenheit.text: ${fahrenheit.text}, f: $f, c: $c, c.toString: ${c.toString}")
      celsius.text = c.toString
    case EditDone(`celsius`) =>
      val c = Integer.parseInt(celsius.text)
      val f = c * 9 / 5 + 32
      println(s"celsius.text: ${celsius.text}, c: $c, f: $f, f.toString: ${f.toString}")
      fahrenheit.text = f.toString
  }
}