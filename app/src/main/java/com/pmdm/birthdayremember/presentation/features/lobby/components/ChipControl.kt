package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CardGiftcard
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.Pix
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.components.chip.ChipCommon
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.MIN_DP
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme

@Composable
fun ChipControl(
    listChipActions: List<ChipAction<LobbyEvent>>
) {
    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {
        listChipActions.forEach { chipAction ->
            Spacer(Modifier.padding(MIN_DP))

            ChipCommon(
                chipAction = chipAction,
            )
        }
    }
}

@Preview
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
}