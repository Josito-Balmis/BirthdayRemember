package com.pmdm.birthdayremember.infraestructure.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pmdm.birthdayremember.infraestructure.room.dao.EventDao
import com.pmdm.birthdayremember.infraestructure.room.dao.GroupDao
import com.pmdm.birthdayremember.infraestructure.room.entity.EventEntity
import com.pmdm.birthdayremember.infraestructure.room.entity.GroupEntity
import com.pmdm.birthdayremember.infraestructure.room.mapper.DatabaseConverter

@Database(
    entities = [EventEntity::class, GroupEntity::class],
    version = 2,
    exportSchema = true
)
@TypeConverters(DatabaseConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun groupDao(): GroupDao

    companion object {
        fun getDataBase(
            context: Context
        ) =
            Room.databaseBuilder(
                context,
                AppDataBase::class.java, "birthday_bd"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration(false)
                .build()
    }
}