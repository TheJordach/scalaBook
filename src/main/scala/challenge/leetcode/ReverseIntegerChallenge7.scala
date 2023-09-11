package challenge.leetcode

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

  Example 1:
  Input: x = 123
  Output: 321
  Example 2:

  Input: x = -123
  Output: -321
  Example 3:

  Input: x = 120
  Output: 21

  Constraints:
  -231 <= x <= 231 - 1
  Accepted 2.8M
  Submissions 10M
  Acceptance Rate 27.8%
*/

class ReverseIntegerChallenge7 {

  def reverse(x: Int): Unit = {


    val minRange = (math.pow(-2, 31)).toLong
    val maxRange = (math.pow(2, 31) - 1).toLong


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
      case _ if x < 0 && x >= minRange => processInput(x) * -1 // original input what negative
      case 0 => 0
    }




  }
}
