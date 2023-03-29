package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch(Dispatchers.Main) {
        doWorld()
    }
    println("Hello")
}

//suspend fun doWorld