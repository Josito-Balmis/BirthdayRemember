package com.pmdm.birthdayremember.infraestructure.room.mapper

import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.infraestructure.room.dto.GroupDto
import com.pmdm.birthdayremember.infraestructure.room.entity.GroupEntity

fun GroupEntity.toDomain() = Group(
    id, name
)

fun Group.toDao() = GroupEntity(
    id, name
)

fun List<GroupEntity>.toListDomain() = map {
    it.toDomain()
}

fun List<Group>.toListDao() = map {
    it.toDao()
}

fun GroupDto.toEntity() = GroupEntity(
    id = 0,
    name = name,
)