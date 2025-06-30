package com.pmdm.birthdayremember.domain.repository

import com.pmdm.birthdayremember.domain.entity.Birthday

interface BirthdayRepository {
    suspend fun get(): List<Birthday>
    suspend fun get(id: Long): Birthday
    suspend fun insert(birthday: Birthday)
    suspend fun update(birthday: Birthday)
    suspend fun delete(id: Long)
}