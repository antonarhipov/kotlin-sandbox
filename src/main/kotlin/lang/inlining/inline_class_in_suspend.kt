package lang.inlining

import kotlinx.coroutines.delay

@JvmInline
value class Wrapper(val value: String)

fun f(){
    val w: Wrapper = Wrapper("hello")
}

suspend fun testing(): Wrapper {
    delay(1)
    return Wrapper("asdfd")
}