package cl.serlitoral.desafiokotlinmarsrover.common


import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun stringDate(dateStr: String): Date {
        var date = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        try {
            date = sdf.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }

    fun readableDate(date: Date): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return sdf.format(date)
    }
}