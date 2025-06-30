package com.pmdm.birthdayremember.domain.repository

import com.pmdm.birthdayremember.domain.entity.Group

interface GroupRepository {
    suspend fun get(): List<Group>
    suspend fun get(id: Int): Group
    suspend fun insert(group: Group)
    suspend fun update(group: Group)
    suspend fun delete(id: Int)
}