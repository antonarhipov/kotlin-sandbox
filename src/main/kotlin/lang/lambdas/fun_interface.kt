package lang.lambdas

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

fun checkNumberIsEven(n: Int, predicate: IntPredicate) =
    predicate.accept(n)

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")

    checkNumberIsEven(10, isEven)
}
