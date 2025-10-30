package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.ui.graphics.vector.ImageVector
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction

data class BottomBarAction<Event>(
    override val icon: ImageVector,
    override val name: String,
    override val event: Event
) : ItemAction<Event> {
    override val isSelected: Boolean
        get() = false
}
