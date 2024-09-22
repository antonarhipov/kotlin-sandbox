package lang.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.nio.file.Files
import java.nio.file.Path

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

/**
 * jetbrains annotations
 * micronaut
 * quarkus
 * spring - custom (Repositories, JdbcTemplate, RESTtemplate
 */
suspend fun firstFunction()/*: Unit = withContext(Dispatchers.IO)*/{
    delay(1000)

    Files.lines(Path.of("asdfasdf"))

    throw RuntimeException("haha!")
}
