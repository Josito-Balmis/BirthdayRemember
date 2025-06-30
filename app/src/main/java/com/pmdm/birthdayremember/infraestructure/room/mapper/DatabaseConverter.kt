package com.pmdm.birthdayremember.infraestructure.room.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import java.time.LocalDate
import javax.inject.Singleton

class DatabaseConverter {

    @TypeConverter
    fun fromZodiac(zodiac: Zodiac): String = zodiac.name.name

    @TypeConverter
    fun toZodiac(value: String): Zodiac = Zodiac(Zodiac.ZodiacName.valueOf(value))

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String = date.toString()

    @TypeConverter
    fun toLocalDate(value: String): LocalDate = LocalDate.parse(value)
}