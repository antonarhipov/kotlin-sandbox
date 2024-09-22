package lang.coroutines

import java.util.concurrent.locks.*

val lck = ReentrantLock()

fun aaa() {
    lck.lock()
    try { bbb() }
    finally { lck.unlock() }
}

fun bbb() {
    lck.lock()
    try { println("Working!") }
    finally { lck.unlock() }
}

fun main() {
    aaa()
}