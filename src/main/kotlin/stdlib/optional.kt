package stdlib

import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

fun main() {
    val presentOptional = Optional.of("I'm here!")
    println(presentOptional.getOrNull()) // "I'm here!"

    val absentOptional = Optional.empty<String>()
    println(absentOptional.getOrNull()) // null
    println(absentOptional.getOrDefault("Nobody here!")) // "Nobody here!"

    println(absentOptional.getOrElse {
        println("Optional was absent!")
        "Default value!"
    })
    // "Optional was absent!"
    // "Default value!"
}
