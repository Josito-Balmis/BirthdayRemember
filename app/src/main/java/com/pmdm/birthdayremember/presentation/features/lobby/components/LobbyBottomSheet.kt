package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Category
import androidx.compose.material.icons.twotone.Contacts
import androidx.compose.material.icons.twotone.Event
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.bottomsheet.DefaultBottomSheetOptions
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyNavigationEvent

// Constants

// All options
private fun getOptions(): List<BottomBarAction<LobbyNavigationEvent>> = listOf(
    BottomBarAction(
        icon = Icons.TwoTone.Contacts,
        description = "Importar contactos",
        event = LobbyNavigationEvent.OnNavigateImportContacts
    ),
    BottomBarAction(
        icon = Icons.TwoTone.Event,
        description = "Añadir un evento",
        event = LobbyNavigationEvent.OnNavigateAddEvent
    ),
    BottomBarAction(
        icon = Icons.TwoTone.Category,
        description = "Añadir categoría",
        event = LobbyNavigationEvent.OnNavigateAddCategory
    )
)

// Main function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyBottomSheetOptions(
    sheetState: SheetState,
    onLobbyEvent: (LobbyEvent) -> Unit,
    onNavigate: (LobbyNavigationEvent) -> Unit,
) {
    val options = getOptions()

    DefaultBottomSheetOptions<LobbyNavigationEvent>(
        sheetState = sheetState,
        options = options,
        onDismissRequest = {
            onLobbyEvent(LobbyEvent.OnShowBottomSheet(isShow = false))
        },
        onClick = { onNavigate(it) }
    )
}


