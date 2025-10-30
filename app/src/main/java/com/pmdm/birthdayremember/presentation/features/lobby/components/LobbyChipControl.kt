package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pmdm.birthdayremember.presentation.components.chip.ChipCommon
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.features.eventcreator.mapper.toBottomBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyEvent
import com.pmdm.birthdayremember.presentation.model.GroupUiState

@Composable
fun LobbyChipControl(
    listGroups: List<GroupUiState>,
    onLobbyEvent: (LobbyEvent) -> Unit,
) {
    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {
        listGroups.forEach { group ->
            Spacer(Modifier.padding(MIN_DP))

            ChipCommon<LobbyEvent>(
                action = group.toBottomBarAction(LobbyEvent.OnSelectGroup(group.id)),
                onEvent = {
                    onLobbyEvent(it)
                }
            )
        }
    }
}

