package com.pmdm.birthdayremember.presentation.components.floatingbutton

import androidx.compose.ui.graphics.vector.ImageVector

data class FloatingActionButton<T>(
    val icon : ImageVector,
    val description : String?,
    val event : T
)