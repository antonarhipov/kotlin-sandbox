package lang.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel: Channel<Int> = Channel()
    val shutdown: Channel<Any> = Channel()

    launch(Dispatchers.IO) {
        for (i in 0..10) {
            println("Sending $i")
            channel.send(i)
            delay(100L)
        }
    }

    launch {
        for (n in channel) {
            println("Received: $n")
            if (n == 10) {
                shutdown.send("OK")
            }
        }
    }

    launch {
        shutdown.receive()
        println("Closing channels")
        channel.close()
        shutdown.close()
    }
}


