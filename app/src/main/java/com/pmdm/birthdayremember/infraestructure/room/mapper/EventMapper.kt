package com.pmdm.birthdayremember.infraestructure.room.mapper

import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.domain.valueobject.EventDate
import com.pmdm.birthdayremember.infraestructure.room.entity.EventEntity

fun EventEntity.toDomain() = Event(
    id = id,
    group = Group(id = idGroup),
    name = name,
    eventDate = EventDate(date),
    notes = notes,
    image = image
)

fun Event.toDao() = EventEntity(
    id = id,
    idGroup = group.id,
    name = name,
    date = eventDate.localDate,
    notes = notes,
    image = image
)

fun List<EventEntity>.toListDomain() = map {
    it.toDomain()
}

fun List<Event>.toListDao() = map {
    it.toDao()
}