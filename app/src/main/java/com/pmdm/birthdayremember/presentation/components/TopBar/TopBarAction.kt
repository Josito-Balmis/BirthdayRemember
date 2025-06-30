package com.pmdm.birthdayremember.presentation.components.TopBar

import androidx.compose.ui.graphics.vector.ImageVector

data class TopBarAction(
    val icon: ImageVector,
    val description: String?,
    val action: () -> Unit,
    val enabled: Boolean = true
)
