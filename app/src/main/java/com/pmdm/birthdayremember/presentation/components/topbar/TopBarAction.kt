package com.pmdm.birthdayremember.presentation.components.topbar

import androidx.compose.ui.graphics.vector.ImageVector

data class TopBarAction<T>(
    val icon: ImageVector,
    val description: String?,
    val event: T,
    val enabled: Boolean = true
)
