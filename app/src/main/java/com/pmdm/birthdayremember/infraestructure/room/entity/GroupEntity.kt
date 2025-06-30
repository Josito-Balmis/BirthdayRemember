package com.pmdm.birthdayremember.infraestructure.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GroupEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name : String
)