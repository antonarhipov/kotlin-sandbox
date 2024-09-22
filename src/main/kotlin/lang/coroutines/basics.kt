package lang.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

private var zeroTime = System.currentTimeMillis()
fun log(message: Any?) =
    println(
        "${System.currentTimeMillis() - zeroTime} " +
                "[${Thread.currentThread().name}] $message"
    )

fun main() = runBlocking {
    println("The first, parent, coroutine starts")
//    coroutineScope {

        launch {
            println("The second coroutine starts and is ready to be suspended")
            helloWorld()
        }
        launch {
            println("The third coroutine can run in the meantime")
        }
//    }
    println("The first coroutine has launched two more coroutines")
}


fun main3() = runBlocking {
    val world = async(Dispatchers.IO) {
        doWorld()
    }
    println("Hello ${world.await()}")
}


fun main123123() = runBlocking {
    launch(Dispatchers.Main) {
        doWorld()
    }
    println("Hello")
}

suspend fun doWorld(): String {
    delay(1000L)
    return "World!"
}


@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceInts(): ReceiveChannel<Double> = produce {
    var i = 0.1
    while (true) {
        i += 0.1
        send(i)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.square(numbers: ReceiveChannel<Double>): ReceiveChannel<Double> = produce {
    for (x in numbers) send(x * x)
}

suspend fun helloWorld() {
    delay(1000L)
    println("World!")

//    coroutineScope {
//
//    }
}



