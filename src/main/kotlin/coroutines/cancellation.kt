package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        withTimeoutOrNull(2000.milliseconds) {
            repeat(1000) { i ->
//                try {
                    // print a message twice a second
                    println("job: I'm sleeping $i ...")
                    delay(100)
//                } catch (e: Exception) {
                    // log the exception
//                    println(e)
//                }
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}