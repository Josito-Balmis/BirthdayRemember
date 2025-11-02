package com.pmdm.birthdayremember.domain.valueobject

import java.time.LocalDate
import java.time.MonthDay
import java.time.temporal.ChronoUnit

class EventDate(
    val localDate: LocalDate
) {
    fun age(): Int = LocalDate.now().year - localDate.year

    fun futureAge(): Int = age() + 1

    fun remainingDays(): Int {
        val now = LocalDate.now()
        var next = MonthDay.from(localDate).atYear(now.year)
        if (!next.isAfter(now)) next = next.plusYears(1)
        return ChronoUnit.DAYS.between(now, next).toInt()
    }

    // Own LocalDate has a method which return whether a date is leap or not
    companion object {
        fun isLeap(year: Int): Boolean {
            if (year % 4 != 0) return false
            if (year % 100 != 0) return true
            if (year % 400 == 0) return true

            return false
        }
    }
}
