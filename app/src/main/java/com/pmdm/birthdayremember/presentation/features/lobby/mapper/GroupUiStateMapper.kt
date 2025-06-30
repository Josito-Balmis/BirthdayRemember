package com.pmdm.birthdayremember.presentation.features.lobby.mapper

import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState

fun Group.toUi() = GroupUiState(
    id = id,
    name = name,
    icon = null,
    isSelected = false
)

fun List<Group>.toListUi() = map {
    it.toUi()
}