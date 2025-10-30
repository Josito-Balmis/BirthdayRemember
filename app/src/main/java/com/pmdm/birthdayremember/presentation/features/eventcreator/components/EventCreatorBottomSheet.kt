package com.pmdm.birthdayremember.presentation.features.eventcreator.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.bottomsheet.DefaultBottomSheetOptions
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCreatorBottomSheet(
    options: List<ItemAction<EventsCreatorEvent>>,
    onEvent: (EventsCreatorEvent) -> Unit,
    sheetState: SheetState
) {
    DefaultBottomSheetOptions(
        sheetState = sheetState,
        options = options,
        onDismissRequest = {},
        onClick = { onEvent(it) }
    )
}