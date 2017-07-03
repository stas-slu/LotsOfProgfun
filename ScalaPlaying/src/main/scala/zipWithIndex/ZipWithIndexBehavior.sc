val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

/**
  * zipWithIndex force second iteration in order to get the index!
  */
days.zipWithIndex.foreach {
  case(day, index) => System.out.println(s"Day: $day, index: $index")
}

val colors = Array("RED", "GREEN", "BLUE")

/**
  * can be solved by using 'view'
  */
days.view.zipWithIndex.foreach {
  case(color, index) => System.out.println(s"Color: $color, index: $index")
}


