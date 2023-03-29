package generics

class Box<T>(t: T) {
    var value = t
}

val box = Box(1)


fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

fun main() {
    val copyWhenGreater = copyWhenGreater(listOf("a", "b", "c"), "f")
    println(copyWhenGreater)
}