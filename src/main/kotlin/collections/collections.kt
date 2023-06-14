package collections

import extensions.Color
import java.util.*


fun main() {

    data class User(val name: String, val age: Int)
    val user = User("John", 23)

    val (name, age) = user // destructing declaration calls componentN()

    val (onlyName) = user

    val olderUser = user.copy(age = 42)

    val g: Color = Color.valueOf("green".uppercase(Locale.getDefault()))

    when(g) {
        Color.RED -> println("blood")
        Color.GREEN -> println("grass")
        Color.BLUE -> println("sky")
        else -> {}
    }



//
//    val users = listOf(
//        User("Jack", 21),
//        User("Jill", 22),
//        User("Jane", 27),
//        User("Anton", 41),
//        User("Leo", 25)
//    )
//
//    users.filter { it.name.startsWith("J") }
//    users.map { it.name }
//
//    users.sortedBy { it.name.last() }
//    users.sortedByDescending { it.age }
//
//    users.maxBy { it.age }
//
//    users.groupBy { it.name.first() }
//
//    users.sumOf { it.age }
//
//    users.reduce { u1, u2 ->
//        if (u1.age >= u2.age) u1 else u2
//    }
//
//    val map = mutableMapOf<String, Int>()
//    users.associateTo(map) {
//        it.name to it.age
//    }

}
