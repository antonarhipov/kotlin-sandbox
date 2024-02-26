package release190


import kotlin.enums.enumEntries


enum class PLANETS(val moons: Int) {
    MERCURY(0), VENUS(0), EARTH(1), MARS(2), JUPITER(5), SATURN(66),
    URANUS(62), NEPTUNE(13)
}

val planets = PLANETS.entries.filterNot { it.moons == 0 }

val range = 1..<10

@JvmInline
value class Person(private val fullName: String) {
    init {
        check(fullName.isNotBlank()) {
            "Full name shouldn't be empty"
        }
    }

    constructor(firstName: String, lastName: String) : this("$firstName $lastName") {
        check(lastName.isNotBlank()) { "Last name shouldn't be empty" }
    }
}

operator fun String.rangeUntil(other: String) = if (this.length > other.length) IntRange(other.length, length) else
    IntRange(length, other.length)



fun regexp(){

    val regex = "\\b(?<city>[A-Za-z\\s]+),\\s(?<state>[A-Z]{2}):\\s(?<areaCode>[0-9]{3})\\b"
        .toRegex()

    val input = "Coordinates: Austin, TX: 123"

    val match = regex.find(input)!!
    println(match.groups["city"]?.value)
    // Austin
    println(match.groups["state"]?.value)
    // TX
    println(match.groups["areaCode"]?.value)
    // 123
}


object MyObject {
    init {
        println("side effect!")
    }

    const val y = 1
}

fun main1() {
    println(MyObject.y)	// no initialization at first
    val x = MyObject	// initialization occurs
    println(x.y)
}
