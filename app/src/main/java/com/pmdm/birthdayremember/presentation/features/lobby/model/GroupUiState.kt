package com.pmdm.birthdayremember.presentation.features.lobby.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.graphics.vector.ImageVector
import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

data class GroupUiState(
    val id: Int = 0,
    override val name: String = "",
    override val icon: ImageVector? = null,
    override val isSelected: Boolean = false,
) : ChipAction<LobbyEvent> {

    override val event: LobbyEvent
        get() = LobbyEvent.OnSelectGroup(id)
}
