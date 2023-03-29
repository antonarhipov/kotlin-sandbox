package intro

import kotlinx.coroutines.yield

fun main() {
    sequence {
        for (i in 0 until 10) {
            yield(i)
        }
    }.forEach { println(it) }
}







