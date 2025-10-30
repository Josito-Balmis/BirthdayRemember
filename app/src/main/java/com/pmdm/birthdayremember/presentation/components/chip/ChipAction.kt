package com.pmdm.birthdayremember.presentation.components.chip

import androidx.compose.ui.graphics.vector.ImageVector

data class ChipAction<Event>(
    val name: String,
    val icon: ImageVector?,
    val isSelected: Boolean,
    val event: Event
)