package challenge.leetcode

/*
6.9 Problems
 1. Write a program to read html contents from https://www.scala-lang.
    org and store this content in a text file. Display the size of this file on the console.
 2. Read the contents of the file produced by the program for Problem #1 and find the total occurrence of word Scala.
 3. Browse the website of The Guardian, https://www.theguardian.com/ world.
    Please note the response time, qualitatively; it is pretty fast compared
    with CNN, http://www.cnn.com/. This site was implemented using the Scala based framework, Play (as of 2017).
    Let’s assume there is a competition for these two sites and the winner is determined by the occurrence of the word
    “news” on the home page, i.e., the higher the occurrence, the higher will be the score.
    Now, write a program that reads the contents, performs the necessary analysis, and decides the winner.
    Print the name and count for both the websites and display the winner, on the console.
    -----------------------------------------------------------------------------------------
    source book: Programming with Scala. Language Exploration-Springer(2017)
 */
 import scala.collection.mutable
 import scala.io.Source
 import scala.util.matching.Regex
object ReadFromURL {


  def countOccurrenceOfNewsWord(url1:String,url2:String,websiteName1:String,websiteName2:String):Unit= {

    /*
    This pattern looks for the word "news" (case-insensitive) surrounded by word boundaries.
    The \\b represents word boundaries, and the "i" flag makes the search case-insensitive.*/
    val patternToFind = new Regex("\\bnews\\b", "i")
    val wordCounts = mutable.Map[String, Int]()


   def urlAnalysis(url:String,websiteName:String): mutable.Map[String,Int] = {
    val contents = Source.fromURL(url).mkString
    val matches = patternToFind.findAllMatchIn(contents).toList
    val score = matches.length
    wordCounts += (websiteName-> score)

    wordCounts
  }


  urlAnalysis(url1,websiteName1)
  urlAnalysis(url2,websiteName2)


  println(wordCounts)
  println(
    s" The maximum is : ${wordCounts("The Guardian") max wordCounts("CNN")}")

  }

  def main(arg:Array[String]) :Unit= {
    val theGuardianWebsiteUrl = "https://www.theguardian.com/"
    val cnnWebsiteUrl = "https://edition.cnn.com/"

    println(countOccurrenceOfNewsWord(theGuardianWebsiteUrl,cnnWebsiteUrl,"The Guardian","CNN"))

  }


}
