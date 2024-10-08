package lang.example

// data classes
// main -> hello -> uppercase (extension)
// randomCase extension -> single-expression function
// trailing lambda
// default values and named arguments
// null-safety

fun main() {
    val devoxx = "Devoxx"
    println("Hello, ${devoxx.randomCase(
        thresholdValue = 0.5
    )}!")
}

fun String.randomCase(thresholdValue: Double = 5.0) = this.map {
    if (Math.random() < thresholdValue) it.lowercaseChar()
    else it.uppercaseChar()
}.joinToString("")
