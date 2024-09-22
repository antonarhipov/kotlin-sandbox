package lang.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    runBlocking {
        withTimeoutOrNull(500.milliseconds) {
            repeat(10_000) {
                poll(it)
            }
        }
    }
}


suspend fun poll(value: Int): Any {
    println("Polling $value")
    while (true) {
        println("working...")

        val x = pollKafka1().also { println("Result 1: $it") }
        if (x < Random.nextDouble(2.0)) {
            return x
        }

        println("still working")

        val y = pollKafka2().also { println("Result 2: $it") }
        if (y < Random.nextDouble(2.0)) {
            return y
        }

        println("Cycle complete: $x $y")
    }
}

suspend fun pollKafka1(): Int {
    println("polling kafka 1")
    delay(110) // can throw timeout cancellation exception
    println("done polling kafka 1")
    return 1
}

suspend fun pollKafka2(): Int {
    println("polling kafka 2")
    delay(110) // can throw timeout cancellation exception
    println("done polling kafka 2")
    return 2
}
