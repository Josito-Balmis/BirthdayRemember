package com.pmdm.birthdayremember.infraestructure.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pmdm.birthdayremember.infraestructure.room.entity.BirthdayEntity

@Dao
interface BirthdayDao {
    @Query("SELECT * FROM BirthdayEntity")
    suspend fun get(): List<BirthdayEntity>

    @Query("SELECT * FROM BirthdayEntity WHERE id = :id")
    suspend fun get(id: Long): BirthdayEntity

    @Insert
    suspend fun insert(birthdayEntity: BirthdayEntity)

    @Update
    suspend fun update(birthdayEntity: BirthdayEntity)

    @Query("DELETE FROM BirthdayEntity WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT COUNT(*) FROM BirthdayEntity")
    suspend fun count(): Int
}