package com.pmdm.birthdayremember.infraestructure.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import java.time.LocalDate


@Entity(
    foreignKeys = [ForeignKey(
        entity = GroupEntity::class,
        parentColumns = ["id"],
        childColumns = ["idGroup"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["idGroup"])]

)
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idGroup: Int,
    val name: String,
    val date: LocalDate,
    val notes: String?,
    val image: String?
)
