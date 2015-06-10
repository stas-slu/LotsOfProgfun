package JsonMappings

import java.io.StringWriter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

case class Person( name:String, age:Int )

object JsonMappings extends {

  def main(args: Array[String]) {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    val person = Person("fred", 25)

    val out = new StringWriter
    mapper.writeValue(out, person)
    val json = out.toString()
    println(s"Created json: $json")

    val person2 = mapper.readValue(json, classOf[Person])
    println(s"Value readed from json: $person2")
  }
}
