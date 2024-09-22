package lang.scopefunctions

fun main() {

}


fun GetRejectedRequests(arr: Array<String>, limitPerSecond: Int): Array<Int> {
    // IP -> timestamp -> number of requests for this timestamp
    val ipToTimestamps = mutableMapOf<String, MutableMap<Long, Long>>()
    val rejectedRequests = mutableListOf<Int>()

    for (request in arr) {
        val parts = request.split(" ")
        val orderNumber = parts[0].toInt()
        val ip = parts[1]
        val timestamp = parts[2].toLong()

        // Get the timestamps for the current IP
        val timestamps = ipToTimestamps.getOrPut(ip) { mutableMapOf() }

        // Remove timestamps older than 1 second
        timestamps.entries.removeAll { it.key <= timestamp - 1000 }

        // Check if the potential number of requests (including the current one) within the last second exceeds the limit
        if (timestamps.values.sum() + 1 > limitPerSecond) {
            rejectedRequests.add(orderNumber)
        } else {
            // Add the current timestamp
            timestamps[timestamp]?.let { timestamps[timestamp] = it + 1 } ?: run { timestamps[timestamp] = 1 }



        }
    }

    return rejectedRequests.toTypedArray()
}