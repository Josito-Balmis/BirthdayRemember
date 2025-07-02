package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pmdm.birthdayremember.presentation.components.chip.ChipCommon
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.MIN_DP
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState

@Composable
fun ChipControl(
    listGroups: List<GroupUiState>,
    onLobbyEvent: (LobbyEvent) -> Unit,
) {
    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {
        listGroups.forEach { group ->
            Spacer(Modifier.padding(MIN_DP))

            ChipCommon(
                action = group,
                onEvent = {
                    onLobbyEvent(it)
                }
            )
        }
    }
}

/*@Preview
@Composable
fun PreviewChipControl() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            ChipControl(
                listChipActions = listOf(
                    ChipAction(
                        text = "Cumpleaños",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Check,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = TODO(),
                        enabled = true,
                    ),
                    ChipAction(
                        text = "Aniversario",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Pix,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = TODO(),
                        enabled = false
                    ),
                    ChipAction(
                        text = "Fallecimiento",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Pix,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = TODO(),
                        enabled = false
                    ),
                )
            )
        }
    }
}*/