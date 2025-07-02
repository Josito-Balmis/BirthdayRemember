package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetCommon(
    sheetState: SheetState,
    onLobbyEvent: (LobbyEvent) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            onLobbyEvent(LobbyEvent.OnShowCreateEvent(false))
        },
        sheetState = sheetState
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Probando el ModalBottomSheet")
        }
    }
}