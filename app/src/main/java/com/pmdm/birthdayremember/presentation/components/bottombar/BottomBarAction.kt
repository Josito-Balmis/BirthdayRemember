package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarAction<Event>(
    val icon: ImageVector,
    val description : String,
    val event: Event
)
