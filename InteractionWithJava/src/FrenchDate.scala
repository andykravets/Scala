import java.text.DateFormat._
import java.util.{Locale, Date}

/**
 * Created by Andrew Kravets on 2/22/14.
 */
object FrenchDate {
  def main(args: Array[String]){
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}
