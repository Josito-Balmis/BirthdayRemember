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
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetAddEvent(
    sheetState: SheetState,
    onLobbyEvent: (LobbyEvent) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            onLobbyEvent(LobbyEvent.OnShowCreateEvent(false))
        },
        sheetState = sheetState,
        // modifier = Modifier.fillMaxSize()
    ) {
        Box(
            //modifier = Modifier.fillMaxWidth(),
            //contentAlignment = Alignment.
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                options.forEach { (icon, text) ->
                    TextButton(
                        onClick = {},
                        Modifier.fillMaxWidth()
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(Modifier.padding(start = 100.dp))
                            Icon(icon, null)
                            Spacer(Modifier.padding(5.dp))
                            Text(text)
                        }
                    }
                }
            }
        }
    }
}


private val options = listOf(
    Icons.TwoTone.Contacts to "Importar contactos",
    Icons.TwoTone.Event to "Añadir un evento",
    Icons.TwoTone.Category to "Añadir categoría",

    )