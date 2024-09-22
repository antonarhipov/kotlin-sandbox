package lang.coroutines
import java.util.concurrent.Executors

fun getStringLength(y: Any): Int {
    val x: String? = y as? String
    return x?.length ?: -1
}



fun main() {
    val executorService = Executors.newFixedThreadPool(4)
    for (i in 1..6) {
        executorService.execute {
            println("[${Thread.currentThread().name}] Computation$i")
        }
    }
    executorService.shutdown()
}
