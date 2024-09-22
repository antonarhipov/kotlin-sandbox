package lang.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

val mutex2 = Mutex()
val random = Random(10)

suspend fun foo2(i: Int) {
    println("$i foo2")
    mutex2.withReentrantLock {
        println("$i foo2 - mutex")
        doSomeWork2(i)
        delay(random.nextLong(100))
        println("$i foo2 - mutex finished")
    }
    println("$i foo2 - finished")
}

suspend fun doSomeWork2(i: Int) {
    println("$i doSomeWork2")
    mutex2.withReentrantLock {
        println("$i doSomeWork2 - mutex")
        println("$i Hello!")
        delay(random.nextLong(100))
        println("$i doSomeWork2 - mutex finished")
    }
    delay(random.nextLong(1000))
    println("$i doSomeWork2 - done")
}

suspend fun main() {
    coroutineScope {
        launch { foo2(1) }
        launch { foo2(2) }
        launch { foo2(3) }
        launch { foo2(4) }
        launch { foo2(5) }
    }
//    foo2(1)
//    foo2(2)
//    foo2(3)
//    foo2(4)
}

suspend fun <T> Mutex.withReentrantLock(block: suspend () -> T): T {
    val key = ReentrantMutexContextKey(this)

    // call block directly when this mutex is already locked in the context
    if (coroutineContext[key] != null) return block()

    // otherwise add it to the context and lock the mutex
    return withContext(ReentrantMutexContextElement(key)) {
        withLock { block() }
    }
}

class ReentrantMutexContextElement(override val key: ReentrantMutexContextKey) : CoroutineContext.Element

data class ReentrantMutexContextKey(val mutex: Mutex) : CoroutineContext.Key<ReentrantMutexContextElement>
