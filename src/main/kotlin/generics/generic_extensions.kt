package generics

import extensions.Color

inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}


fun main() {
    val pair = ("1" to "2").asPairOf<String, String>()
    println(pair)


    buildList {
        add("")
    }.apply { }


    val list = listOf(1, "Hello", Color.RED)
    val strings: List<String> = list.filterIsInstance<String>()


    println(strings)
}