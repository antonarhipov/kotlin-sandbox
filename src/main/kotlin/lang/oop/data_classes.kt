package lang.oop


/**
 * Features:
 * equals()/hashCode() pair
 * toString() of the form "User(name=Anton, age=24)"
 * componentN() functions corresponding to the properties in their order of declaration.
 * copy() function
 */

fun main() {

    data class User(val name: String, val age: Int)

    val jack = User("Jack", 24)
    val jill = jack.copy(name = "Jill")

    val mapOfUsers = mapOf(
        1 to jack,
        2 to jill
    )

    val (name, age) = jack
    println("$name is $age")




    println(mapOfUsers)

}