package com.pmdm.birthdayremember.domain.valueobject

import java.time.LocalDate
import java.time.MonthDay
import java.time.temporal.ChronoUnit

class BirthdayDate(
    private val birthdayDate: LocalDate
) {
    // Own LocalDate object has a method which return whether a date is leap or not
    companion object {
        fun isLeap(year: Int): Boolean {
            if (year % 4 != 0) return false
            if (year % 100 != 0) return true
            if (year % 400 == 0) return true

            return false
        }
    }

    fun currentAge(): Int {
        val currentDate = LocalDate.now()

        return currentDate.year - birthdayDate.year
    }

    fun futureAge(): Int {
        val currentAge = currentAge()
        return currentAge + 1
    }

    fun daysAlive(): Int {
        val currentDate = LocalDate.now()

        var days = 0
        for (year in birthdayDate.year..currentDate.year) {
            if (isLeap(year))
                days++

            days += 365
        }

        return days
    }

    fun remainingDaysToBirthday(): Int {
        val currentDate = LocalDate.now()
        val birthdateWithCurrentYear = MonthDay.from(birthdayDate).atYear(currentDate.year)

        if (birthdateWithCurrentYear.isBefore(currentDate)) {
            birthdateWithCurrentYear.plusYears(1)
        }

        return ChronoUnit.DAYS.between(currentDate, birthdateWithCurrentYear).toInt()
    }



}