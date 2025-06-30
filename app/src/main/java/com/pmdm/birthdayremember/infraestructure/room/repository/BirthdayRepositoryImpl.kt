package com.pmdm.birthdayremember.infraestructure.room.repository

import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.infraestructure.room.mapper.*
import com.pmdm.birthdayremember.domain.repository.BirthdayRepository
import com.pmdm.birthdayremember.infraestructure.room.dao.BirthdayDao
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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