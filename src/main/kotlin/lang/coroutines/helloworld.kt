package lang.coroutines

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors


var counter = 0

private val dispatcher =
    Executors.newFixedThreadPool(2) { Thread(it, "asset-tx-tracker-db-persister") }.asCoroutineDispatcher()

suspend fun persist() = withContext(dispatcher) {
    launch {
        ///
    }
    launch {
        ///
    }
}