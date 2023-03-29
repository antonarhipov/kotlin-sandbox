package annotations

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.full.findAnnotations

@Repeatable
annotation class Tag(val name: String)

@Tag("First Tag")
@Tag("Second Tag")
fun taggedFunction() {
    println("I'm a tagged function!")
}

fun main() {
    val x = ::taggedFunction
    val foo = x as KAnnotatedElement

    // [@Tag(name=First Tag), @Tag(name=Second Tag)]
    println(foo.findAnnotations<Tag>())
}
