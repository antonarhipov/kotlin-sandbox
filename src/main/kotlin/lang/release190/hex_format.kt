package lang.release190


@OptIn(ExperimentalStdlibApi::class)
fun main() {

    println(123.toHexString(HexFormat.UpperCase)) //0000007B

    println(123.toHexString(HexFormat {
        upperCase = true
        number {
            removeLeadingZeros = true
            prefix = "#"
        }
    }))  // #7B

    val bytes = "Kotlin 1.9.0".toByteArray()
    val format = HexFormat {
        bytes {
            bytesPerLine = 4
            byteSeparator = ":"
            bytePrefix = "0x"
        }
    }
    println(bytes.toHexString(format))


    val hex = "0x4b:0x6f:0x74:0x6c:0x69:0x6e"

    hex.hexToByteArray(HexFormat {
        bytes {
            bytePrefix = "0x"
            byteSeparator = ":"
        }
    })
    .map { print(it.toInt().toChar()) }

}

fun objc_release(objc_release: String) {
    TODO("Not yet implemented")
}

private fun getThead() = "Main"

