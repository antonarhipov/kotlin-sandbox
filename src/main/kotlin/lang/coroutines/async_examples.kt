package lang.coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield


suspend fun main() {
    System.setProperty("kotlinx.coroutines.debug", "on" )

    val handler: suspend (Int) -> Unit = { i: Int ->
        println("Coroutine $i starting: ${Thread.currentThread().name}")
        yield()
        println("Coroutine $i finished: ${Thread.currentThread().name}")
    }

    coroutineScope {
        withContext(Dispatchers.IO){
            listOf(1, 2, 3, 4, 5, 6).map {
                async {
                    handler(it)
                }
            }
        }
    }.awaitAll()
}
