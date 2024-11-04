@file:OptIn(ExperimentalContracts::class)
package lang.contracts


import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {
    barkIfDog(getAnimal())
}

fun barkIfDog(animal: Animal) = when {
    animal.isHusky() -> animal.bark()
    else -> println("Not a dog")
}

private fun Animal.isHusky() : Boolean {
    contract {
        returns(true) implies (this@isHusky is Dog)
    }
    return this is Dog && breed.contains("husky", ignoreCase = true)
}

fun getAnimal(): Dog = Dog("husky")

open class Animal
class Dog(val breed: String): Animal(){
    fun bark(){
        println("Woof")
    }
}
