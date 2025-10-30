package com.pmdm.birthdayremember.presentation.components.bottomsheet

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomSheetAction<Event>(
    val name: String,
    val icon: ImageVector?,
    val event: Event
)
