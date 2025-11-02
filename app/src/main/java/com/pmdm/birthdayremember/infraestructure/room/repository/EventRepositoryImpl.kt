package com.pmdm.birthdayremember.infraestructure.room.repository

import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.domain.repository.BirthdayRepository
import com.pmdm.birthdayremember.infraestructure.room.dao.BirthdayDao
import com.pmdm.birthdayremember.infraestructure.room.mapper.toDao
import com.pmdm.birthdayremember.infraestructure.room.mapper.toDomain
import com.pmdm.birthdayremember.infraestructure.room.mapper.toListDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BirthdayRepositoryImpl @Inject constructor(
    private val birthdayDao: BirthdayDao
) : BirthdayRepository {

    override suspend fun get(): List<Birthday> = withContext(Dispatchers.IO) {
        birthdayDao.get().toListDomain()
    }

    override suspend fun get(id: Long): Birthday = withContext(Dispatchers.IO) {
        birthdayDao.get(id).toDomain()
    }

    override suspend fun getAllByGroup(idGroup: Int): List<Birthday> = withContext(Dispatchers.IO) {
        birthdayDao.getAllByGroup(idGroup).toListDomain()
    }

    override suspend fun getByGroup(idGroup: Int): Birthday = withContext(Dispatchers.IO) {
        birthdayDao.getByGroup(idGroup).toDomain()
    }

    override suspend fun getAllByName(name: String): List<Birthday> = withContext(Dispatchers.IO) {
        birthdayDao.getAllByName(name).toListDomain()
    }

    override suspend fun getByName(name: String): Birthday = withContext(Dispatchers.IO) {
        birthdayDao.getByName(name).toDomain()
    }

    override suspend fun getAllByNameAndGroup(name: String, idGroup: Int): List<Birthday> =
        withContext(Dispatchers.IO) {
            birthdayDao.getAllByNameAndGroup(name, idGroup).toListDomain()
        }

    override suspend fun getByNameAndGroup(name: String, idGroup: Int): Birthday =
        withContext(Dispatchers.IO) {
            birthdayDao.getByNameAndGroup(name, idGroup).toDomain()
        }

    override suspend fun insert(birthday: Birthday) = withContext(Dispatchers.IO) {
        birthdayDao.insert(birthday.toDao())
    }

    override suspend fun update(birthday: Birthday) = withContext(Dispatchers.IO) {
        birthdayDao.update(birthday.toDao())
    }

    override suspend fun delete(id: Long) = withContext(Dispatchers.IO) {
        birthdayDao.delete(id)
    }
}