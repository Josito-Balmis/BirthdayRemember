package com.pmdm.birthdayremember.presentation.features.lobby.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AlignHorizontalCenter
import androidx.compose.material.icons.twotone.Cake
import androidx.compose.material.icons.twotone.Celebration
import androidx.compose.ui.graphics.vector.ImageVector
import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.presentation.model.GroupUiState

fun Group.toUi() = GroupUiState(
    id = id,
    name = name,
    icon = groupChipIconMapper(id),
)

fun List<Group>.toListUi(): List<GroupUiState> = map {
    it.toUi()
}

private fun groupChipIconMapper(id: Int): ImageVector? {
    return when (id) {
        1 -> Icons.TwoTone.Cake
        2 -> Icons.TwoTone.Celebration
        3 -> Icons.TwoTone.AlignHorizontalCenter
        else -> null
    }
}