package com.pmdm.birthdayremember.domain.valueobject

import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Acuario
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Aries
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Capricornio
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Cancer
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Escorpio
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Geminis
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Leo
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Libra
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Piscis
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Sagitario
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Tauro
import com.pmdm.birthdayremember.domain.valueobject.Zodiac.ZodiacName.Virgo
import java.time.LocalDate
import java.time.MonthDay

data class Zodiac(
    val name: ZodiacName
) {
    enum class ZodiacName {
        Ninguno, Aries, Tauro, Geminis, Cancer, Leo, Virgo, Libra, Escorpio, Sagitario, Capricornio, Acuario, Piscis
    }

    companion object {
        fun getZodiacSignByDate(date: LocalDate): Zodiac {
            val dia = MonthDay.of(date.month, date.dayOfMonth)

            val name = when {
                dia >= MonthDay.of(3, 21) && dia <= MonthDay.of(4, 19) -> Aries
                dia >= MonthDay.of(4, 20) && dia <= MonthDay.of(5, 20) -> Tauro
                dia >= MonthDay.of(5, 21) && dia <= MonthDay.of(6, 20) -> Geminis
                dia >= MonthDay.of(6, 21) && dia <= MonthDay.of(7, 22) -> Cancer
                dia >= MonthDay.of(7, 23) && dia <= MonthDay.of(8, 22) -> Leo
                dia >= MonthDay.of(8, 23) && dia <= MonthDay.of(9, 22) -> Virgo
                dia >= MonthDay.of(9, 23) && dia <= MonthDay.of(10, 22) -> Libra
                dia >= MonthDay.of(10, 23) && dia <= MonthDay.of(11, 21) -> Escorpio
                dia >= MonthDay.of(11, 22) && dia <= MonthDay.of(12, 21) -> Sagitario
                dia >= MonthDay.of(12, 22) || dia <= MonthDay.of(1, 19) -> Capricornio
                dia >= MonthDay.of(1, 20) && dia <= MonthDay.of(2, 18) -> Acuario
                dia >= MonthDay.of(2, 19) && dia <= MonthDay.of(3, 20) -> Piscis
                else -> throw IllegalArgumentException("Signo zodiaco desconocido.")
            }

            return Zodiac(name)
        }
    }
}
