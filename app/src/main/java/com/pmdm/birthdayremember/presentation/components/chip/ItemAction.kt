package com.pmdm.birthdayremember.presentation.components.chip

import androidx.compose.ui.graphics.vector.ImageVector

interface ItemAction<Event> {
    val name: String
    val icon: ImageVector?
    val isSelected: Boolean
    val event: Event
}