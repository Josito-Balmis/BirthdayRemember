package com.pmdm.birthdayremember.infraestructure.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pmdm.birthdayremember.infraestructure.room.entity.GroupEntity

@Dao
interface GroupDao {
    @Query("SELECT * FROM GroupEntity")
    suspend fun get(): List<GroupEntity>

    @Query("SELECT * FROM GroupEntity WHERE id = :id")
    suspend fun get(id: Int): GroupEntity?

    @Insert
    suspend fun insert(groupEntity: GroupEntity)

    @Update
    suspend fun update(groupEntity: GroupEntity)

    @Query("DELETE FROM GroupEntity WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT COUNT(*) FROM GroupEntity")
    suspend fun count() : Int
}