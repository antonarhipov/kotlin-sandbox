package me.anton

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrElse
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactor.ReactorContext
import kotlinx.coroutines.reactor.asCoroutineContext
import kotlinx.coroutines.reactor.asFlux
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.context.Context


fun main() = runBlocking<Unit> {



    val flow = flow<Int> {
        println("Reactor context in Flow: " + coroutineContext[ReactorContext])
//        println("Reactor context in Flow: " + currentCoroutineContext()[ReactorContext])
    }

    // No context
    flow.asFlux().subscribe() // 'Reactor context in Flow: null'

    // Add subscriber's context
    flow.asFlux()
        .contextWrite { ctx -> ctx.put("answer", 42) }
        .subscribe() // Will print "Reactor context in Flow: Context{'answer'=42}"


}
