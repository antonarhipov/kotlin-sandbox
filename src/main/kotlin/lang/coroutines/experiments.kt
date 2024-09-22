package lang.coroutines

import kotlin.concurrent.thread

fun main() {
    repeat(100_000) {
        thread {
            Thread.sleep(10000L)
            if (it % 10000 == 0) {
                print(it)
            }
        }
    }
}

class VersionControlSystemConnection(val fullUrl: String) {
    init {
        println(fullUrl)
    }
}