package book.programmingWithScala
import scala.collection.mutable
import scala.util.matching.Regex
object RegularExpressions {

  import java.io.{IOException, FileNotFoundException}
  import scala.io.Source
  import java.io.File

  def openDirectory:Unit = {
    var listOfDirectory: List[File] = List[File]()
    val savedFile = "/home/jordach/Pictures"
    val directory = new File(savedFile)

    if (directory.exists() && directory.isDirectory) {
      listOfDirectory = directory.listFiles.filter(_.isFile).toList
    } else {
      listOfDirectory = List[File]()
    }
    listOfDirectory.foreach(println)
  }



  def main(arg:Array[String]):Unit = {

    println(openDirectory)

  }



}
