package com.pmdm.birthdayremember.presentation.components.chip

import androidx.compose.ui.graphics.vector.ImageVector
import com.pmdm.birthdayremember.domain.entity.Group
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState

data class ChipAction<T>(
    val group: GroupUiState,
    val iconAvatar: ImageVector,
    val iconTrailing: ImageVector,
    val descriptionAvatar: String?,
    val descriptionTrailing: String?,
    val onClick: T
)