package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Category
import androidx.compose.material.icons.twotone.Contacts
import androidx.compose.material.icons.twotone.Event
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyNavigationEvent

// Constants
private val START_PADD = 100.dp

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
    ModalBottomSheet(
        onDismissRequest = {
            onLobbyEvent(LobbyEvent.OnShowBottomSheet(false))
        },
        sheetState = sheetState,
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                getOptions().forEach { option ->
                    TextButton(
                        onClick = { onNavigate(option.event) },
                        Modifier.fillMaxWidth()
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(Modifier.padding(start = START_PADD))
                            Icon(option.icon, null)
                            Spacer(Modifier.padding(MIN_DP))
                            Text(option.description!!)
                        }
                    }
                }
            }
        }
    }
}


