package coroutines

import kotlinx.coroutines.sync.Mutex

val mutex = Mutex()

suspend fun foo() {
    println("In foo")
    mutex.lock()
    try { doSomeWork() }
    finally { mutex.unlock() }
}

suspend fun doSomeWork() {
    println("doSomeWork")
    mutex.lock()
    try { println("Working!") }
    finally { mutex.unlock() }
}

suspend fun main() {
    foo()
}