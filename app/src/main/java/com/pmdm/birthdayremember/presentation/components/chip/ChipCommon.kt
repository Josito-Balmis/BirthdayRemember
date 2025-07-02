package com.pmdm.birthdayremember.presentation.components.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <Event> ChipCommon(
    modifier: Modifier = Modifier,
    action: ChipAction<Event>,
    onEvent: (Event) -> Unit
) {
    InputChip(
        modifier = modifier,
        selected = action.isSelected,
        onClick = { onEvent(action.event) },
        label = { Text(action.name) },
        avatar = {
            Icon(
                imageVector = action.icon ?: Icons.Default.BrokenImage,
                contentDescription = null,
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            if (action.isSelected)
                Icon(
                    imageVector = Icons.TwoTone.Check,
                    contentDescription = null,
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
        }
    )

}