package ru.ok.android.itmohack2023.pixels

class MeasurementService {
    val measurements = mutableMapOf<String, Long>()

    fun start(id: String) {
        // start time measurement
        measurements[id] = System.currentTimeMillis()
    }

    fun end(id: String): Int {
        // calculate time difference in milliseconds
        val startTime = measurements.remove(id) ?: return -1
        val endTime = System.currentTimeMillis()
        val elapsedTime = (endTime - startTime).toInt()
        return elapsedTime
    }
}