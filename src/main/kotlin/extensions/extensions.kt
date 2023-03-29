package extensions

import kotlin.random.Random

fun demo() {
    val name = "World"

    // HeLlO, wOrld!
    println("Hello, $name!".sarcastic())
}


// "Hello, World!".sarcastic() -> HeLlO, wOrld!
fun String.sarcastic() = asIterable().joinToString("") {
    if (Random.nextBoolean()) it.uppercase() else it.lowercase()
}






fun join(vararg str: String, s: String = ","): String =
    str.joinToString(separator = s)

// if value a is null, yield b
fun selectNotNull(a: Any?, b: Any) = a ?: b


fun demo3() {
    val values = arrayOf("String", true, 1)
    for (v in values) {
        when (v) {
            is String -> println("This is String: $v")
            is Boolean -> println("This is String: $v")
            is Int -> println("This is String: $v")
        }
    }
}



fun demo2() {
    val strings = arrayOf("a", "b", "c")
    join(*strings)
    Circle(1.0)
}


enum class Color { TRANSPARENT, BLACK, WHITE, RED, GREEN, BLUE,}

interface Shape {
    fun draw()
    fun area(): Double
}

class Circle(diameter: Double) : Shape {
    val radius = diameter / 2

    override fun area(): Double = Math.PI * radius * radius
    override fun draw() {
        // draw the object
    }
}




fun <T> List<T>.permutations(): List<List<T>> =
    when {
        size < 2 -> listOf(this)
        size == 2 -> listOf(listOf(first(), last()), listOf(last(), first()))
        else -> flatMap { element ->
            (this - element).permutations().map { listOf(element) + it }
        }
    }