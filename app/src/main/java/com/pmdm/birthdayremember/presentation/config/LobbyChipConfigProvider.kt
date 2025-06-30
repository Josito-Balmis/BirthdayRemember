package com.pmdm.birthdayremember.presentation.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CardGiftcard
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.Pix
import com.pmdm.birthdayremember.presentation.components.Chip.ChipAction
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

class LobbyChipConfigProvider : ChipConfigProvider<LobbyEvent> {

    override fun getChips(
        onClick: (LobbyEvent) -> Unit
    ): List<ChipAction<LobbyEvent>> {
        return listOf(
            ChipAction(
                text = "Cumpleaños",
                iconAvatar = Icons.TwoTone.CardGiftcard,
                iconTrailing = Icons.TwoTone.Check,
                descriptionAvatar = null,
                descriptionTrailing = null,
                onClick = { onClick(LobbyEvent.OnSelectGroup(1)) },
                enabled = true,
            ),
            ChipAction(
                text = "Aniversario",
                iconAvatar = Icons.TwoTone.CardGiftcard,
                iconTrailing = Icons.TwoTone.Pix,
                descriptionAvatar = null,
                descriptionTrailing = null,
                onClick = onClick,
                enabled = false
            ),
            ChipAction(
                text = "Fallecimiento",
                iconAvatar = Icons.TwoTone.CardGiftcard,
                iconTrailing = Icons.TwoTone.Pix,
                descriptionAvatar = null,
                descriptionTrailing = null,
                onClick = onClick,
                enabled = false
            )
        )
    }
}