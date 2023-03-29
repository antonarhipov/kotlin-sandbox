package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) {
            delay(100L) // Heavy computation
            channel.send(x * x)
        }
    }
    // here we print five received integers:
    repeat(5) { println(channel.receive()) }
    println("Done!")
}


