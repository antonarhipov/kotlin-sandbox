package receivers

//region receivers
//region extension
private fun String.sarcastic(): String = asIterable().joinToString("") {
    if(kotlin.random.Random.nextBoolean()) it.uppercase() else it.lowercase()
}
//endregion

//region lambda with the receiver
fun printTransformedGreeting(transform: String.() -> Unit) {
    val greeting = "Hello world!"
    val transformed = greeting.transform()
    println(transformed)
}
//endregion

//region 'with' function
class Logger(val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

class Api {
    fun get(): String = "Hello, World"
}

fun playingWithWith(){
    val logger = Logger("Main")
    with(logger) {
        with(Api()) {
            log(get())
        }
    }
}
//endregion
//endregion


fun store(s: String) {
    println("Stored $s on disk")
}