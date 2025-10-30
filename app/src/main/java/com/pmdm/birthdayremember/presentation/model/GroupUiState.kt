package com.pmdm.birthdayremember.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector

data class GroupUiState(
    val id: Int = 0,
    val name: String = "",
    val icon: ImageVector? = null,
    val isSelected: Boolean = false,
)