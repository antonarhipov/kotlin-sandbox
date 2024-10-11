package lang.coroutines

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.sse.*
import kotlinx.coroutines.flow.flow

suspend fun main() {
    fetchEvents().collect { println("Collected: $it") }
}

val http: HttpClient = HttpClient(CIO) {
    install(SSE)
}

fun fetchEvents() = flow<String> {
    http.sse(host = "0.0.0.0", port = 8080, path = "/sse") {
        while (true) {
            incoming.collect {
                emit(it.data.toString())
            }
        }
    }
}

