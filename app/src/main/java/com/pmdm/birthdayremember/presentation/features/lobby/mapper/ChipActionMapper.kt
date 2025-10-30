package com.pmdm.birthdayremember.presentation.features.lobby.mapper

import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.model.GroupUiState


fun <Event> GroupUiState.toChipAction(createEvent: (GroupUiState) -> Event) = ChipAction(
    name = name,
    icon = icon,
    isSelected = isSelected,
    event = createEvent(this)
)
