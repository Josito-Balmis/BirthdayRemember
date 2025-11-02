package com.pmdm.birthdayremember.infraestructure.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pmdm.birthdayremember.infraestructure.room.entity.EventEntity

@Dao
interface EventDao {
    @Query("SELECT * FROM EventEntity")
    suspend fun get(): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    suspend fun get(id: Long): EventEntity?

    @Query("SELECT * FROM EventEntity WHERE idGroup = :idGroup")
    suspend fun getAllByGroup(idGroup: Int): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE idGroup = :idGroup")
    suspend fun getByGroup(idGroup: Int): EventEntity?

    @Query("SELECT * FROM EventEntity WHERE name = :name")
    suspend fun getAllByName(name: String): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE name = :name")
    suspend fun getByName(name: String): EventEntity?

    @Query("SELECT * FROM EventEntity WHERE name = :name and idGroup = :idGroup")
    suspend fun getAllByNameAndGroup(name: String, idGroup: Int): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE name = :name and idGroup = :idGroup")
    suspend fun getByNameAndGroup(name: String, idGroup: Int): EventEntity?

    @Insert
    suspend fun insert(eventEntity: EventEntity)

    @Update
    suspend fun update(eventEntity: EventEntity)

    @Query("DELETE FROM EventEntity WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT COUNT(*) FROM EventEntity")
    suspend fun count(): Int

}