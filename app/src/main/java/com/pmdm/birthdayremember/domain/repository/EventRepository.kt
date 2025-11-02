package com.pmdm.birthdayremember.domain.repository

import com.pmdm.birthdayremember.domain.entity.Birthday

interface BirthdayRepository {
    suspend fun get(): List<Birthday>
    suspend fun get(id: Long): Birthday
    suspend fun getAllByGroup(idGroup: Int): List<Birthday>
    suspend fun getByGroup(idGroup: Int): Birthday
    suspend fun getAllByName(name: String): List<Birthday>
    suspend fun getByName(name: String): Birthday
    suspend fun getAllByNameAndGroup(name: String, idGroup: Int): List<Birthday>
    suspend fun getByNameAndGroup(name: String, idGroup: Int): Birthday
    suspend fun insert(birthday: Birthday)
    suspend fun update(birthday: Birthday)
    suspend fun delete(id: Long)
}