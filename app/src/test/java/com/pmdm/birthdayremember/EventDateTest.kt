package com.pmdm.birthdayremember

import com.pmdm.birthdayremember.domain.valueobject.EventDate
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EventDateTest {


    @Test
    fun `it should be a leap year`() {
        val years = listOf(
            2000, 2004, 2008, 2012, 2016
        )

        for (year in years) {
            assertTrue(
                "El año $year debería ser bisiesto.", EventDate.isLeap(year)
            )
        }
    }

    @Test
    fun `it shouldn't be a leap year`() {
        val years = listOf(
            2001, 2002, 2003, 2005, 2006
        )

        for (year in years) {
            assertTrue(
                "El año $year no debería ser bisiesto.", EventDate.isLeap(year).not()
            )
        }
    }

    @Test
    fun `returns the correct currently age`() {
        val eventDate = EventDate(
            localDate = LocalDate.of(2003, 3, 2)
        )
        val currentyAge = eventDate.age()

        assertTrue("La edad actual deberia de ser de 22 años", currentyAge == 22)
    }

    @Test
    fun `returns the correct future age`() {
        val eventDate = EventDate(
            localDate = LocalDate.of(2003, 3, 2)
        )
        val futureAge = eventDate.futureAge()

        assertTrue("La edad futura deberia de ser 23", futureAge == 23)
    }

    @Test
    fun `returns the correct remaining days for the birtday`() {
        val eventDate = EventDate(
            localDate = LocalDate.of(2003, 6, 26)
        )

        val days = eventDate.remainingDays()
        assertTrue("Debería de haber devuelto 1 día total", days == 0)
    }


}