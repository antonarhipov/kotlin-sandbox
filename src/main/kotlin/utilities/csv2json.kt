package utilities

import kotlinx.serialization.json.*
import java.io.File

/**
 * Converts CSV string to JSON string
 * @param csv Input CSV string
 * @param delimiter CSV delimiter character (default is comma)
 * @param hasHeader Whether CSV has a header row (default is true)
 * @return JSON string representation of the CSV data
 */
fun csvToJson(csv: String, delimiter: Char = ',', hasHeader: Boolean = true): String {
    if (csv.isEmpty()) return "[]"

    val lines = csv.lines().filter { it.isNotBlank() }
    if (lines.isEmpty()) return "[]"

    fun parseCsvLine(line: String, delimiter: Char): List<String> {
        val values = mutableListOf<String>()
        var currentValue = StringBuilder()
        var insideQuotes = false

        var i = 0
        while (i < line.length) {
            val char = line[i]
            when {
                char == '"' -> {
                    if (insideQuotes && i + 1 < line.length && line[i + 1] == '"') {
                        // Handle escaped quotes
                        currentValue.append('"')
                        i++
                    } else {
                        insideQuotes = !insideQuotes
                    }
                }
                char == delimiter && !insideQuotes -> {
                    values.add(currentValue.toString().trim())
                    currentValue = StringBuilder()
                }
                else -> currentValue.append(char)
            }
            i++
        }
        values.add(currentValue.toString().trim())
        return values.map { value ->
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value.substring(1, value.length - 1)
            } else {
                value
            }
        }
    }

    val headers = if (hasHeader) {
        parseCsvLine(lines[0], delimiter)
    } else {
        List(parseCsvLine(lines[0], delimiter).size) { "column$it" }
    }

    val dataStartIndex = if (hasHeader) 1 else 0
    val jsonArray = buildJsonArray {
        for (i in dataStartIndex until lines.size) {
            val values = parseCsvLine(lines[i], delimiter)
            if (values.size != headers.size) {
                throw IllegalArgumentException("Row ${i + 1} has ${values.size} values but expected ${headers.size} (matching headers)")
            }
            addJsonObject {
                headers.zip(values).forEach { (header, value) ->
                    put(header, value)
                }
            }
        }
    }

    return jsonArray.toString()
}

/**
 * Converts CSV file content to JSON string
 * @param csvContent Input CSV file content
 * @param delimiter CSV delimiter character (default is comma)
 * @param hasHeader Whether CSV has a header row (default is true)
 * @return JSON string representation of the CSV data
 * @throws IllegalArgumentException if CSV content is malformed
 */
@Throws(IllegalArgumentException::class)
fun csvFileToJson(csvContent: String, delimiter: Char = ',', hasHeader: Boolean = true): String {
    try {
        return csvToJson(csvContent, delimiter, hasHeader)
    } catch (e: Exception) {
        throw IllegalArgumentException("Failed to parse CSV content: ${e.message}", e)
    }
}

fun main() {
    val csvFile = File("/Users/anton/IdeaProjects/data-explorer/data/spotify.csv")
    if (!csvFile.exists()) {
        println("CSV file not found.")
        return
    }
    val csvContent = csvFile.readText()
    try {
        val jsonOutput = csvFileToJson(csvContent)
        println(jsonOutput)

        val jsonFile = File(csvFile.parent, csvFile.nameWithoutExtension + ".json")
        jsonFile.writeText(jsonOutput)
        println("JSON output written to: ${jsonFile.path}")
    } catch (e: IllegalArgumentException) {
        println("Error converting CSV to JSON: ${e.message}")
    }
}
