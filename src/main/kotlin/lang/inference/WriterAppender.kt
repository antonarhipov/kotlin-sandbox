package lang.inference

fun interface Printer {
    fun print()
}

val printer = Printer {
    println("hello!")
}

fun main() {
    printer.print()
}

