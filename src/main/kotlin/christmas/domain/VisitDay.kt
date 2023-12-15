package christmas.domain

import christmas.domain.Calendar.*

class VisitDay(private val day: Int) {

    init {
        require(day in 1..31)
    }

    fun isWeekDay() = WEEKDAY.contains(day)

    fun isWeekEnd() = WEEKEND.contains(day)

    fun isSpecial() = SPECIAL.contains(day)
}