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
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarCommon
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarAction
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarCommon
import com.pmdm.birthdayremember.presentation.features.lobby.components.BottomSheetCommon
import com.pmdm.birthdayremember.presentation.features.lobby.components.ChipControl
import com.pmdm.birthdayremember.presentation.features.lobby.components.ListBirthdays
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme

// Constants
val MIN_DP = 5.dp

//Main Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyScreen(
    listGroups: List<GroupUiState>,
    listBirthdays: List<BirthdayUiState>,
    listTopBarActions: List<TopBarAction<LobbyEvent>>,
    listBottomBarActions: List<BottomBarAction<LobbyEvent>>,
    showBottomSheet: Boolean,
    onLobbyEvent: (LobbyEvent) -> Unit,
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
            BottomBarCommon(
                onClick = onLobbyEvent,
                actions = listBottomBarActions,
                floatingAction = FloatingActionButton<LobbyEvent>(
                    icon = Icons.TwoTone.CardGiftcard,
                    description = "Button for add a new birthday",
                    event = LobbyEvent.OnShowCreateEvent(true)
                )
            )
        }
    ) {
        Surface(Modifier.padding(it)) {
            Column(Modifier.fillMaxWidth()) {
                ChipControl(
                    listGroups = listGroups,
                    onLobbyEvent = onLobbyEvent
                )

                ListBirthdays(listBirthdays)

                if (showBottomSheet)
                    BottomSheetCommon(
                        sheetState = sheetState,
                        onLobbyEvent = onLobbyEvent
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
                listGroups = listOf(
                    GroupUiState(name = "Hola")
                ),
                listBirthdays = listOf(),
                listTopBarActions = listOf(),
                onLobbyEvent = {},
                listBottomBarActions = listOf(),
                showBottomSheet = TODO()
            )
        }
    }
}




