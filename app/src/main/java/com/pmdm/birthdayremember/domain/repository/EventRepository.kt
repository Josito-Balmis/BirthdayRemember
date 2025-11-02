package com.pmdm.birthdayremember.domain.repository

import com.pmdm.birthdayremember.domain.entity.Event

interface EventRepository {
    suspend fun get(): List<Event>
    suspend fun get(id: Long): Event?
    suspend fun getAllByGroup(idGroup: Int): List<Event>
    suspend fun getByGroup(idGroup: Int): Event?
    suspend fun getAllByName(name: String): List<Event>
    suspend fun getByName(name: String): Event?
    suspend fun getAllByNameAndGroup(name: String, idGroup: Int): List<Event>
    suspend fun getByNameAndGroup(name: String, idGroup: Int): Event?
    suspend fun insert(event: Event)
    suspend fun update(event: Event)
    suspend fun delete(id: Long)
}