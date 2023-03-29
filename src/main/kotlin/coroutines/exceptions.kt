package coroutines

import kotlinx.coroutines.delay

suspend fun main() {
    runCatching {
        firstFunction()
    }.onSuccess {
        println("success!")
        delay(2000)
    }.onFailure {
        println("function failed")
        delay(2000)
    }
    println("yay")
}

suspend fun firstFunction(){
    delay(1000)
    throw RuntimeException("haha!")
}
