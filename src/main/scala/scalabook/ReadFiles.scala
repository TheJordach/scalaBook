package scalabook

/*
Problem statement
Write a program that
1. reads words from a file.
2. Use a mutable map to count how often each word appears.
To read the words, simply use a java.util.Scanner:
*/

//import libraries
import java.util.Scanner
import java.io.File
import scala.collection.mutable

class ReadFiles {

  /******
   * This function take a path of a text/html like file ("path/to/file.txt")
   * use a mutable Map to keep track the count of duplicated words.
   * and repeat the following operation in each line
   *
   *  {
   *   1.read line
   *   2.read each words in a line
   *   3-isolate each word and create a Seq of words
   *   4. iterate over the Seq check if each word exist in the Map
   *       if its does, update the count
   *       else set the count  to 0
   *   4.count the words which are duplicated and keep track the count
   *  }
   *
   * @param filePath : String
   * @output Map[String,Int]
   *
   */

  def read(filePath: String): mutable.Map[String,Int] = {

    val file = new File(filePath)
    val scanner = new Scanner(file)
    val wordCountMap = mutable.Map.empty[String, Int]

    while(scanner.hasNextLine) {
      val line = scanner.nextLine()
      val words = line.split(" ") // isolate each word and create a Seq of words

      for (word <-words) {
      val count = wordCountMap.getOrElse(word,0)
      wordCountMap.updated(word,count+1)
      }
    }

    scanner.close() //close the file

    wordCountMap

  }
  def readFileWithApache(filePath:String):Unit = {

  }
}


object ReadFiles{
  def apply():ReadFiles =new ReadFiles()
}
