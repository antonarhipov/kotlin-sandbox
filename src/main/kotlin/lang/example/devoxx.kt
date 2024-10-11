package lang.example

// data classes
// main -> hello -> uppercase (extension)
// randomCase extension -> single-expression function
// trailing lambda
// default values and named arguments
// null-safety
// type-safe builders

fun main() {
    val event = getEventName()
    println("Hello, ${event?.uppercase()}!")
    println("Hello, ${event?.randomCase(offset = 0.25)}!")
}

private fun getEventName(): String? = "Devoxx"

fun String.transform(transformer: (String) -> String) =
    transformer(this)

fun String.randomCase(chance: Double = 0.5, offset: Double = 0.1): String = map {
    if (Math.random() < chance + offset)
        it.uppercaseChar() else it.lowercaseChar()
}.joinToString("")
