package intro

fun main() {
    print("Input: ")
    val (a, b) = readInts()
    println("total: ${a+b}")
}


fun readInts() = readLine()!!.split(" ").map(String::toInt)
fun readInt() = readLine()!!.toString().apply {  }


