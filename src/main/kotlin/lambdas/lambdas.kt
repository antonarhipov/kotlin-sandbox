package lambdas

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int =
    operation(x, y)


fun main() {
    fun add(x: Int, y: Int) = x + y

    val sum = calculate(4, 5, operation = ::add)
    val mul = calculate(4, 5) { a, b -> a * b }

    println("sum=$sum, mul=$mul")
}




