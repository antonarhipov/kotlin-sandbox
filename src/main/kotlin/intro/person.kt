package intro

class Person(val name: String, val age: Int)

fun main() {
    val person = Person("Anton", 16)
    println(person.prettyPrint())


    class Blah : AutoCloseable {
        override fun close() {
            TODO("Not yet implemented")
        }
    }

    Blah().use {

    }

}

fun Person.prettyPrint(): String =
    "Person{name=${this.name}, age=${this.age}}"