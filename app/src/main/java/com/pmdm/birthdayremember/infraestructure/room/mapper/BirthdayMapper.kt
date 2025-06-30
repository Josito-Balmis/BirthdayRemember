package com.pmdm.birthdayremember.infraestructure.room.mapper

import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.infraestructure.room.entity.BirthdayEntity

fun BirthdayEntity.toDomain() = Birthday(
    id,
    idGroup,
    zodiac,
    name,
    date,
    hasYear,
    notes,
    image
)

fun Birthday.toDao() = BirthdayEntity(
    id,
    idGroup,
    zodiac,
    name,
    date,
    hasYear,
    notes,
    image
)

fun List<BirthdayEntity>.toListDomain() = map {
    it.toDomain()
}

fun List<Birthday>.toListDao() = map {
    it.toDao()
}