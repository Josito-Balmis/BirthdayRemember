package com.pmdm.birthdayremember.infraestructure.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pmdm.birthdayremember.infraestructure.room.dao.BirthdayDao
import com.pmdm.birthdayremember.infraestructure.room.dao.GroupDao
import com.pmdm.birthdayremember.infraestructure.room.entity.BirthdayEntity
import com.pmdm.birthdayremember.infraestructure.room.entity.GroupEntity
import com.pmdm.birthdayremember.infraestructure.room.mapper.DatabaseConverter

@Database(
    entities = [BirthdayEntity::class, GroupEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(DatabaseConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun birthdayDao(): BirthdayDao
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