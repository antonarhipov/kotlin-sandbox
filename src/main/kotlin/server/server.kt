package server

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/") {
                call.respondText { "Hello, World!" }
            }
            get("/{id}") {
                call.parameters["id"]?.toInt() ?: error("Invalid id")
                call.respondText { "Hello, #${call.parameters["id"]}" }
            }
        }

    }.start(wait = true)
}