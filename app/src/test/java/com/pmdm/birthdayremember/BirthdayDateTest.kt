package com.pmdm.birthdayremember

import com.pmdm.birthdayremember.domain.valueobject.BirthdayDate
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BirthdayDateTest {


    @Test
    fun `it should be a leap year`() {
        val years = listOf(
            2000, 2004, 2008, 2012, 2016
        )

        for (year in years) {
            assertTrue(
                "El año $year debería ser bisiesto.", BirthdayDate.isLeap(year)
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
                "El año $year no debería ser bisiesto.", BirthdayDate.isLeap(year).not()
            )
        }
    }

    @Test
    fun `returns the correct currently age`() {
        val birthdayDate = BirthdayDate(
            birthdayDate = LocalDate.of(2003, 3, 2)
        )
        val currentyAge = birthdayDate.currentAge()

        assertTrue("La edad actual deberia de ser de 22 años", currentyAge == 22)
    }

    @Test
    fun `returns the correct future age`() {
        val birthdayDate = BirthdayDate(
            birthdayDate = LocalDate.of(2003, 3, 2)
        )
        val futureAge = birthdayDate.futureAge()

        assertTrue("La edad futura deberia de ser 23", futureAge == 23)
    }

    @Test
    fun `returns the correct remaining days for the birtday`() {
        val birthdayDate = BirthdayDate(
            birthdayDate = LocalDate.of(2003, 6, 26)
        )

        val days = birthdayDate.remainingDaysToBirthday()
        assertTrue("Debería de haber devuelto 1 día total", days == 0)
    }


}