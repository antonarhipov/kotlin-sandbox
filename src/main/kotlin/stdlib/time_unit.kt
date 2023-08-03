package stdlib

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeSource
import kotlin.time.TimedValue
import kotlin.time.measureTime
import kotlin.time.measureTimedValue

fun main() {
    timeHasPassed()


    val timeSource = TimeSource.Monotonic
    val mark1 = timeSource.markNow()
    Thread.sleep(500) // Sleep 0.5 seconds.
    val mark2 = timeSource.markNow()

    repeat(4) { n ->
        val mark3 = timeSource.markNow()
        val elapsed1 = mark3 - mark1
        val elapsed2 = mark3 - mark2

        println("Measurement ${n + 1}: diff=${elapsed1 - elapsed2}")
    }
    // It’s also possible to compare time marks with each other.
    println(mark2 > mark1) // This is true, as mark2 was captured later than mark1.


    val time: Duration = measureTime {
        println("test")
    }
    println(time) // 22.808us

    val timedValue: TimedValue<Int> = measureTimedValue {
        (0..99).sum()
    }
    println(timedValue) //TimedValue(value=4950, duration=9.946421ms)

}


fun timeHasPassed(){
    val timeSource = TimeSource.Monotonic
    val mark1 = timeSource.markNow()
    val fiveSeconds = 5.seconds
    val mark2 = mark1 + fiveSeconds

    // It hasn't been 5 seconds yet
    println(mark2.hasPassedNow()) // false
    println(mark2.hasNotPassedNow()) // true

    // Wait six seconds
    Thread.sleep(6000)
    println(mark2.hasPassedNow()) // true

}