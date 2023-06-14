package release1820

import org.jetbrains.Person

fun main() {

    val person = Person("Anton", 21)
    println(person.age)  // 21
    println(person::age) // property age

    val persons = listOf<Person>(Person("Jack", 11), Person("Sofie", 12), Person("Peter", 2))
    persons
        .sortedByDescending(Person::age)
        .forEach { p -> println(p.name) }
}



