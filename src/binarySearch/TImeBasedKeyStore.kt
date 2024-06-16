package binarySearch


class TimeMap {
    private val data = mutableMapOf<String, Pair<Any, Long>>()

    fun put(key: String, value: Any, timestamp: Long) {
        data[key] = Pair(value, timestamp)
    }

    fun get(key: String, current_time: Long): Any? {
        if (data.containsKey(key)) {
            val (value, timestamp) = data[key]!!
            if (timestamp >= current_time) {
                return value
            } else {
                data.remove(key) // Remove expired entry
            }
        }
        return null
    }
}

fun main() {
    val timeMap = TimeMap()
    timeMap.put("key1", "value1", 10)
    println(timeMap.get("key1", 5)) // Output: "value1"
    println(timeMap.get("key1", 15)) // Output: null (expired)
}
