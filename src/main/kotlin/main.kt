fun main2() {
    val values = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val windowSize = 3

    val movingAverages = values.windowed(
        windowSize, 1,
        partialWindows = false
    ) {
        it.average()
    }

    movingAverages.forEach { avg ->
        println("%.2f".format(avg))
    }

//    dslFunction("aaa", 1, 2, 3, 4, 5, 128)
}

fun dslFunction1(s: String, vararg nums: Int, id: () -> Unit) {}

fun dslFunction2(s: String, vararg nums: Int, id: Int) {}

fun dslFunction3(s: String, vararg nums: Int, id: Int.() -> Unit) {}

fun dslFunction4(s: String, vararg nums: Int, id: String) {}












interface AAAA {
    fun bbbb(){ println("hey")
    }
}

fun main() {
    val value = object : AAAA {
    }
    value.bbbb()
}


fun xxx1(p: (String) -> Unit) {}
fun xxx2(p: (Int) -> Unit) {}
fun xxx3(p: () -> Unit) {}
fun xxx4(p: String) {}

