package lang.extensions

fun <T> List<T>.permutations(): List<List<T>> =
    when {
        size < 2 -> listOf(this)
        size == 2 -> listOf(listOf(first(), last()), listOf(last(), first()))
        else -> flatMap { element ->
            (this - element).permutations().map { listOf(element) + it }
        }
    }