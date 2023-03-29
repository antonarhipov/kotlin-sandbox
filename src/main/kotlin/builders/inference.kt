package builders

import java.lang.IllegalArgumentException

fun main() {

    var a: String = "abc"  // not null
//    a = null               // compilation error

    var b: String? = "abc" // can be set to null
    b = null // ok
//    println(b.length)      // error, b can be null


}


