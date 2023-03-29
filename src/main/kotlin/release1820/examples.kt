package release1820

enum class Color(val colorName: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00")
}


@OptIn(ExperimentalStdlibApi::class)
fun findByRgb(rgb: String): Color? = Color.entries.find { it.rgb == rgb }


object MyObject
data object MyDataObject

sealed interface ReadResult
data class Number(val number: Int) : ReadResult
data class Text(val text: String) : ReadResult
data object EndOfFile : ReadResult


@JvmInline
value class Person(private val fullName: String) {
    // Allowed since Kotlin 1.4.30:
    init {
        check(fullName.isNotBlank()) {
            "Full name shouldn't be empty"
        }
    }
    // Preview available since Kotlin 1.8.20:
    constructor(name: String, lastName: String) : this("$name $lastName") {
        check(lastName.isNotBlank()) {
            "Last name shouldn't be empty"
        }
    }
}


fun main() {
    println(findByRgb("#FF0000")?.colorName)
    println("-----------")

    println(MyObject) // org.example.MyObject@1f32e575
    println(MyObject) // org.example.MyObject@1f32e575
    println(MyObject) // org.example.MyObject@1f32e575
    println(MyDataObject) // MyDataObject
    println("-----------")

    println(Number(7)) // Number(number=7)
    println(EndOfFile) // EndOfFile


    println(Person("Anton", "Arhipov"))
}