package datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.time.Duration
import java.time.LocalDate

fun main() {

    val timestamp: Instant = Clock.System.now()
    val utcTime = timestamp.toLocalDateTime(TimeZone.UTC)
    val localTime = timestamp.toLocalDateTime(TimeZone.currentSystemDefault())

    println(timestamp)
    println(utcTime)
    println(localTime)

}