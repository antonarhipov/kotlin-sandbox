package lang.inlining

fun main() {
    val list = listOf(1)
    list.forEveryOther {
        println(it)
    }
}

inline fun Collection<Int>.forEveryOther(block: (Int) -> Unit) {
    for ((i, e) in withIndex()) {
        if (i % 2 == 0) {
            block(e)
        }
    }
}

