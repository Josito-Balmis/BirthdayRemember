package com.pmdm.birthdayremember.presentation.features.lobby.model

import androidx.compose.ui.graphics.vector.ImageVector

data class GroupUiState(
    val id: Int,
    val name: String,
    val icon: ImageVector?,
    val isSelected: Boolean = false
)
