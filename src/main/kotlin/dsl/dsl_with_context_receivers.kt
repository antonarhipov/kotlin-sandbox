package dsl

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random

context(LoggingContext) fun logStuff() = log.info("hello")

fun startBusinessOperation(log: Logger) {
    // You can access the log property since LoggingContext is an implicit receiver
    log.info("Operation has started")
}

fun interface Logger {
    fun info(s: String)
}

class TransactionContext {
    fun start() {
        println("start transaction")
    }

    fun stop() {
        println("stop transaction")
    }
}

class LoggingContext {
    val log = Logger {
        println(it)
    }
}

class WorkflowContext {
    fun stage1(block: () -> Unit) {}
    fun stage2(block: context(TransactionContext) () -> Unit) {
        block(TransactionContext())
    }

    fun stage3(block: context(LoggingContext) () -> Unit) {
        block(LoggingContext())
    }

    context(LoggingContext)


    fun String.sarcastic() = asIterable().joinToString("") {
        if (Random.nextBoolean()) it.uppercase() else it.lowercase()
    }


}


fun workflow(block: context(WorkflowContext) () -> Unit) {
    block(WorkflowContext())
}


fun main() {
    workflow {
        stage1 {

        }
        stage2 {
            start()
            stop()
        }
        stage3 {

            "Hello!".sarcastic()
        }
    }


}
