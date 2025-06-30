package com.pmdm.birthdayremember.infraestructure.room.repository

import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.infraestructure.room.mapper.*
import com.pmdm.birthdayremember.domain.repository.GroupRepository
import com.pmdm.birthdayremember.infraestructure.room.dao.GroupDao
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Singleton
class GroupRepositoryImpl @Inject constructor(
    private val dao: GroupDao
) : GroupRepository {

    override suspend fun get(): List<Group> = withContext(Dispatchers.IO) {
        dao.get().toListDomain()
    }

    override suspend fun get(id: Int): Group = withContext(Dispatchers.IO) {
        dao.get(id).toDomain()
    }

    override suspend fun insert(group: Group) = withContext(Dispatchers.IO) {
        dao.insert(group.toDao())
    }

    override suspend fun update(group: Group) = withContext(Dispatchers.IO) {
        dao.update(group.toDao())
    }

    override suspend fun delete(id: Int) = withContext(Dispatchers.IO) {
        dao.delete(id)
    }
}