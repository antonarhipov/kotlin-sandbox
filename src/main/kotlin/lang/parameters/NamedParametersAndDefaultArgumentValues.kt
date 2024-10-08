package lang.parameters

data class Rectangle(
    val width: Double = 1.0,
    val height: Double = 1.0
) {
    fun area(): Double = width * height
    fun perimeter(): Double = 2 * (width + height)
}

fun main() {
    // Using default argument values
    val default = Rectangle()
    println("Default Rectangle -> Area: ${default.area()}, Perimeter: ${default.perimeter()}")

    // Using named parameters
    val custom = Rectangle(height = 3.0, width = 4.0)
    println("Custom Rectangle -> Area: ${custom.area()}, Perimeter: ${custom.perimeter()}")

    // Combined usage: some defaults, some named parameters
    val mixed = Rectangle(height = 5.0)
    println("Mixed Rectangle -> Area: ${mixed.area()}, Perimeter: ${mixed.perimeter()}")
}