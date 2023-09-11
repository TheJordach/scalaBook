package workingSpace

object workingArea {

  def reverse(x: Int): Unit = {

    val minRange = (math.pow(-2, 31)).toLong
    val maxRange = (math.pow(2, 31) -1).toLong

    def processInput(input: Int): Int = {
      val reversedString = input
        .toString // Convert input to String
        .filter(_.isDigit) // Remove non-digit characters
        .reverse // Reverse the string

      val reversedInt = try {
        reversedString.toInt
        // Attempt to convert the reversed string to Int
      } catch {
        case _: NumberFormatException => 0
        // Handle the case where the conversion fails
      }

      if (reversedInt > maxRange || reversedInt < minRange) {
        0 // Check if the reversed integer is out of range
      } else {
        reversedInt
      }
    }


    x match {
      case _ if x > 0 && x <= maxRange => processInput(x)
      case _ if x < 0 && x >= minRange => processInput(x) * -1// original input what negative
      case 0 => 0
    }





  }























  def main(arg:Array[String]):Unit = {

    val input1 = 123
    val input2 = -123
    val input3 = 102000
    val inputList = List(input1,input2,input3)
    println(reverse(input3))
    /*for (item<- inputList) {
      println(reverse(item))
    }*/
  }

}
