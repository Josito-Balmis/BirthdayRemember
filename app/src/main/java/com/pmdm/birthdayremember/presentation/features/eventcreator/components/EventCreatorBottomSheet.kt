package com.pmdm.birthdayremember.presentation.features.eventcreator.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.pmdm.birthdayremember.presentation.components.bottomsheet.DefaultBottomSheetOptions
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorEvent
import com.pmdm.birthdayremember.presentation.features.eventcreator.mapper.toListBottomSheetAction
import com.pmdm.birthdayremember.presentation.model.GroupUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCreatorBottomSheet(
    options: List<GroupUiState>,
    onEvent: (EventsCreatorEvent) -> Unit,
    sheetState: SheetState
) {
    val listBottomSheetAction = remember {
        options.toListBottomSheetAction { group ->
            EventsCreatorEvent.OnSelectGroup(group.id)
        }
    }

    DefaultBottomSheetOptions(
        sheetState = sheetState,
        options = listBottomSheetAction,
        onDismissRequest = {},
        onClick = { onEvent(it) }
    )
}