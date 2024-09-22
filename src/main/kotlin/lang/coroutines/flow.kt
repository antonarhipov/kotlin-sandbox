package lang.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds


//val numbers = flowOf(100, 200, 300, 400, 500)

fun simple(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
    throw Exception("Catch me!")
}

fun main() = runBlocking {
//    simple()
//        .catch { e -> println("Caught an exception!") }
//        .transform { number ->
//            if(number % 2 == 0)
//                emit(number * number)
//            else
//                emit(number)
//        }
//        .collect { value -> println(value) }

    schedule().collect {
        println(it.toLocalDateTime(TimeZone.currentSystemDefault()))
    }
}

fun schedule(period: Duration = 3000.milliseconds): Flow<Instant> = flow {
    while (true) {
        emit(Clock.System.now())
        delay(period)
    }
}