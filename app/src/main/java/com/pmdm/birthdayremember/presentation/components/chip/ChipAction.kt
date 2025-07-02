package com.pmdm.birthdayremember.presentation.components.chip

import androidx.compose.ui.graphics.vector.ImageVector

data class ChipAction<T>(
    val text: String,
    val iconAvatar: ImageVector,
    val iconTrailing: ImageVector,
    val descriptionAvatar: String?,
    val descriptionTrailing: String?,
    val enabled: Boolean = false,
    val onClick: T
)