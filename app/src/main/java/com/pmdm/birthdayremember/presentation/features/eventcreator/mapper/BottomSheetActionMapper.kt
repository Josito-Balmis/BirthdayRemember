package com.pmdm.birthdayremember.presentation.features.eventcreator.mapper

import com.pmdm.birthdayremember.presentation.components.bottomsheet.BottomSheetAction
import com.pmdm.birthdayremember.presentation.model.GroupUiState


fun <Event> List<GroupUiState>.toListBottomSheetAction(
    createEvent: (GroupUiState) -> Event
): List<BottomSheetAction<Event>> =
    map { group ->
        BottomSheetAction(
            name = group.name,
            icon = group.icon,
            event = createEvent(group)
        )
    }
