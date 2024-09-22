package lang.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun doWork() = coroutineScope {
    val data = doMyWork()
    launch { writeToDatabase(data) }
    sendMessage(data)
}

fun sendMessage(data: Any) {
    TODO("Not yet implemented")
}

fun writeToDatabase(data: Any) {
    TODO("Not yet implemented")
}

fun doMyWork(): Any {
    TODO("Not yet implemented")
}
