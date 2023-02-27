package com.example.project.utils

enum class Weekly(val weekly: String) {
    MON("MON"), TUE("TUE"), WED("WED"), THU("THU"), FRI("FRI"), SAT("SAT"), SUN("SUN");

    companion object {
        fun getParamWeekLy(weekly: String): Weekly? {
            for (weekly in Weekly.values()) {
                if (weekly.weekly.equals(weekly)) {
                    return weekly
                }
            }
            return null
        }
    }

    fun getValue(): String {
        return weekly
    }
}