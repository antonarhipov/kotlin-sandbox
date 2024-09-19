package org.jetbrains

import java.io.File
import java.security.MessageDigest

fun findDuplicateFiles(directoryPath: String, deleteDuplicates: Boolean = false) {
    val fileHashes = mutableMapOf<String, MutableList<String>>()

    File(directoryPath).walk().forEach { file ->
        if (file.isFile) {
            val hash = file.readBytes().toMD5()
            fileHashes.computeIfAbsent(hash) { mutableListOf() }.add(file.path)
        }
    }

    fileHashes.values.filter { it.size > 1 }.forEach { duplicates ->
        println("Duplicates:")
        duplicates.forEach { println("  $it") }

        if (deleteDuplicates) {
            val filesWithLastModified = duplicates.map {
                File(it) to File(it).lastModified()
            }

            val mostRecentFile = filesWithLastModified.minBy { it.second }.first

            filesWithLastModified.forEach { (file, _) ->
                if (file != mostRecentFile) {
                    println("Deleting: ${file.path}")
                    if (file.delete()) {
                        println("Deleted: ${file.path}")
                    } else {
                        println("Failed to delete: ${file.path}")
                    }
                }
            }
        }
    }
}

fun ByteArray.toMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(this)
    return digest.joinToString("") { "%02x".format(it) }
}

fun main() {
    findDuplicateFiles(
        "/your/path/to/files",
        deleteDuplicates = false
    )
}




