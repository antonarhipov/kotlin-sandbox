package lang.coroutines

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.stream.consumeAsFlow
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

suspend fun main() {
    producer().collect { println("Collected: $it") }
}

val client: HttpClient = HttpClient.newBuilder().build()

fun producer() = flow<String> {
    val url = "http://localhost:8080/sse"

    println("Connecting to $url")
    val request: HttpRequest = HttpRequest
        .newBuilder()
        .uri(URI.create(url))
        .header("User-Agent", "Java 11 HttpClient Bot")
        .GET()
        .timeout(Duration.ofSeconds(2))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofLines())

    response.body().consumeAsFlow().collect {
        emit(it)
    }

}

