package stdlib

import java.util.concurrent.TimeUnit
import kotlin.time.*

// cbrt
// toTimeUnit, toDurationUnit   (java.util.concurrent.TimeUnit <=> kotlin.time.DurationUnit)


fun main() {

    j2k(100, TimeUnit.MINUTES)

    val duration = 100.toDuration(DurationUnit.MINUTES)

    j2k(duration.inWholeMinutes, DurationUnit.MINUTES.toTimeUnit())
}


    // calling Kotlin code from Java
    fun j2k(value: Long, unit: TimeUnit) {
        val duration: Duration = value.toDuration(unit.toDurationUnit())
        println("Duration: $duration")
    }




