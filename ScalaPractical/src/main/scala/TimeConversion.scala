package org.scala.practical

object TimeConversion {
  def main(args: Array[String]): Unit = {
    val input: String = "12:05:45PM";
    val output: String = timeConversion(input)
    println(output)
  }

  def timeConversion(format12h: String): String = {
    val timeFormatMap: Map[String, String] = Map(
      "01" -> "13", "02" -> "14", "03"-> "15", "04" -> "16",
      "05"-> "17", "06" -> "18", "07" -> "19", "08"-> "20",
      "09" -> "21", "10" -> "22", "11" -> "23", "12" -> "12"
    )

    val hourPart = format12h.slice(0, 2)
    val remain = format12h.slice(2, 8)
    val amOrPm = format12h.slice(8, 10)

    var hourIn24hFormat: String = ""
    if (amOrPm.equals("AM")) {
      if (hourPart.equals("12")) {
        hourIn24hFormat = "00"
      } else {
        hourIn24hFormat = hourPart
      }
    } else {
      hourIn24hFormat = timeFormatMap(hourPart)
    }

    s"$hourIn24hFormat$remain"
  }
}
