import coroutines.helloWorld
import kotlinx.coroutines.runBlocking

data class MyMessage(val text: String, val id: String)

fun main() {

    val closeable = AutoCloseable {
        println("hello!")
    }

    closeable.use {
        runBlocking {
            helloWorld()
        }
    }

}





fun getListOfClasses() = listOf(
    MyMessage("String", "asdf"),
    MyMessage("String", "asdf"),
    MyMessage("String", "asdf"),
    MyMessage("String", "asdf"),
    MyMessage("String", "asdf"),
    MyMessage("String", "asdf"),
)


fun <T> Iterable<T>.groupConsecutiveBy(groupIdentifier: (T, T) -> Boolean) =
    if (!this.any())
        emptyList()
    else this
        .drop(1)
        .fold(mutableListOf(mutableListOf(this.first()))) { groups, t ->
            groups.last().apply {
                if (groupIdentifier.invoke(last(), t)) {
                    add(t)
                } else {
                    groups.add(mutableListOf(t))
                }
            }
            groups
        }


data class Message(val username: String, val value: Int)


























class A {
    suspend fun close() {}
}

class B {
    suspend fun close() {}
}

class C {
    suspend fun close() {}
}


class PseudoClosableExample {
    lateinit var service: A
    lateinit var broker: B
    lateinit var producer: C

    fun appCleanup() {
        stopProducer()
        stopBroker()
        stopService()
    }

    fun stopProducer() {
        if (this::producer.isInitialized) {
            runBlocking {
                runCatching {
                    producer.close()
                }.onFailure {
                    println("failed to close queue producer: $it")
                }
            }
        }
    }

    fun stopBroker() {
        if (this::broker.isInitialized) {
            runBlocking {
                runCatching {
                    broker.close()
                }.onFailure { println("failed to close queue producer: $it") }
            }
        }
    }

    fun stopService() {
        if (this::service.isInitialized) {
            runBlocking {
                runCatching {
                    service.close()
                }.onFailure { println("failed to close queue producer: $it") }
            }
        }
    }
}

class PseudoClosableExample2 {

    lateinit var service: A
    lateinit var broker: B
    lateinit var producer: C

    fun appCleanup() {
        stopProducer()
        stopBroker()
        stopService()
    }

    fun stopProducer() {
        cleanup(this::producer.isInitialized, producer)
    }

    fun stopBroker() {
        cleanup(this::broker.isInitialized, broker)
    }

    fun stopService() {
        cleanup(this::service.isInitialized, service)
    }

    fun cleanup(isInitialized: Boolean, closeable: Any) {
        if (isInitialized) {
            runBlocking {
                val className = closeable::class.java.simpleName
                runCatching {
                    when (closeable) {
                        is A -> closeable.close()
                        is B -> closeable.close()
                        is C -> closeable.close()
                        else -> {
                            throw IllegalArgumentException("unsupported class $className")
                        }
                    }
                }.onFailure { println("failed to close $className: $it") }
            }
        }
    }
}


class PseudoClosableFunExample {
    lateinit var service: A
    lateinit var broker: B
    lateinit var producer: C

    fun appCleanup() {
        stopResrouce({ this::producer.isInitialized }) { producer.close() }
        stopResrouce({ this::broker.isInitialized }) { broker.close() }
        stopResrouce({ this::service.isInitialized }) { service.close() }
    }

    fun stopResrouce(predicate: () -> Boolean, close: suspend () -> Unit) {
        if (predicate()) {
            runBlocking {
                runCatching {
                    close()
                }.onFailure {
                    println("failed to close the resource: $it")
                }
            }
        }
    }
}