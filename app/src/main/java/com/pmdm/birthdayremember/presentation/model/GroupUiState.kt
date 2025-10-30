package com.pmdm.birthdayremember.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction

data class GroupUiState(
    val id: Int = 0,
    val name: String = "",
    val icon: ImageVector? = null,
    val isSelected: Boolean = false,
)