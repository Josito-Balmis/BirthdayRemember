package com.pmdm.birthdayremember.infraestructure.room.repository

import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.domain.repository.EventRepository
import com.pmdm.birthdayremember.infraestructure.room.dao.EventDao
import com.pmdm.birthdayremember.infraestructure.room.mapper.toDao
import com.pmdm.birthdayremember.infraestructure.room.mapper.toDomain
import com.pmdm.birthdayremember.infraestructure.room.mapper.toListDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    private val eventDao: EventDao
) : EventRepository {

    override suspend fun get(): List<Event> = withContext(Dispatchers.IO) {
        eventDao.get().toListDomain()
    }

    override suspend fun get(id: Long): Event? = withContext(Dispatchers.IO) {
        eventDao.get(id)?.toDomain()
    }

    override suspend fun getAllByGroup(idGroup: Int): List<Event> = withContext(Dispatchers.IO) {
        eventDao.getAllByGroup(idGroup).toListDomain()
    }

    override suspend fun getByGroup(idGroup: Int): Event? = withContext(Dispatchers.IO) {
        eventDao.getByGroup(idGroup)?.toDomain()
    }

    override suspend fun getAllByName(name: String): List<Event> = withContext(Dispatchers.IO) {
        eventDao.getAllByName(name).toListDomain()
    }

    override suspend fun getByName(name: String): Event? = withContext(Dispatchers.IO) {
        eventDao.getByName(name)?.toDomain()
    }

    override suspend fun getAllByNameAndGroup(name: String, idGroup: Int): List<Event> =
        withContext(Dispatchers.IO) {
            eventDao.getAllByNameAndGroup(name, idGroup).toListDomain()
        }

    override suspend fun getByNameAndGroup(name: String, idGroup: Int): Event? =
        withContext(Dispatchers.IO) {
            eventDao.getByNameAndGroup(name, idGroup)?.toDomain()
        }

    override suspend fun insert(event: Event) = withContext(Dispatchers.IO) {
        eventDao.insert(event.toDao())
    }

    override suspend fun update(event: Event) = withContext(Dispatchers.IO) {
        eventDao.update(event.toDao())
    }

    override suspend fun delete(id: Long) = withContext(Dispatchers.IO) {
        eventDao.delete(id)
    }
}