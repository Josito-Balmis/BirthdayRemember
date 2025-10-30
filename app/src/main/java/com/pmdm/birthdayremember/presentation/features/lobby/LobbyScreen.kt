package com.pmdm.birthdayremember.presentation.features.lobby

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CardGiftcard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarCommon2
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarAction
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarCommon
import com.pmdm.birthdayremember.presentation.features.lobby.components.ListBirthdays
import com.pmdm.birthdayremember.presentation.features.lobby.components.LobbyBottomSheetOptions
import com.pmdm.birthdayremember.presentation.features.lobby.components.LobbyChipControl
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyNavigationEvent
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme

//Main Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyScreen(
    lobbyUiState: LobbyUiState,
    listTopBarActions: List<TopBarAction<LobbyEvent>>,
    listBottomBarActions: List<ItemAction<LobbyNavigationEvent>>,
    onLobbyEvent: (LobbyEvent) -> Unit,
    onNavigate: (LobbyNavigationEvent) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        topBar = {
            TopBarCommon(
                scrollBehavior = scrollBehavior,
                actions = listTopBarActions,
                onlick = onLobbyEvent,
            )
        },
        bottomBar = {
            BottomBarCommon2( // Navigation uses T generic and Floating Button uses U generic
                onClickAction = onNavigate,
                actions = listBottomBarActions,
                floatingAction = FloatingActionButton<LobbyEvent>(
                    icon = Icons.TwoTone.CardGiftcard,
                    description = "Button for add a new birthday",
                    event = LobbyEvent.OnShowBottomSheet(true)
                ),
                onClickFloating = onLobbyEvent
            )
        }
    ) {
        Surface(Modifier.padding(it)) {
            Column(Modifier.fillMaxWidth()) {
                LobbyChipControl(
                    listGroups = lobbyUiState.listGroups,
                    onLobbyEvent = onLobbyEvent
                )

                ListBirthdays(lobbyUiState.listBirthdays)

                if (lobbyUiState.showBottomSheet)
                    LobbyBottomSheetOptions(
                        sheetState = sheetState,
                        onLobbyEvent = onLobbyEvent,
                        onNavigate = onNavigate
                    )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLobbyScreen() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            LobbyScreen(
                listTopBarActions = listOf(),
                onLobbyEvent = {},
                listBottomBarActions = listOf(),
                onNavigate = {},
                lobbyUiState = LobbyUiState()
            )
        }
    }
}




