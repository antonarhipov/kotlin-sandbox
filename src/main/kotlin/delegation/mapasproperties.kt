package delegation

data class Data(val data: Map<String, *>) {
    val a: String by data
    val b: String by data


    override fun toString(): String = "Data: {$a, $b}"
}


fun main() {
    val data = Data(mapOf(
        "a" to "1",
        "b" to "2"
    ))

    println(data)
}