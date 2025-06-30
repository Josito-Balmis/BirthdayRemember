package com.pmdm.birthdayremember.presentation.components.Chip

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> ChipCommon(
    modifier: Modifier = Modifier,
    chipAction: ChipAction<T>,
) {
    InputChip(
        modifier = modifier,
        selected = chipAction.enabled,
        onClick = { chipAction.onClick },
        label = { Text(chipAction.text) },
        avatar = {
            Icon(
                imageVector = chipAction.iconAvatar,
                contentDescription = chipAction.descriptionAvatar,
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            if (chipAction.enabled)
                Icon(
                    imageVector = chipAction.iconTrailing,
                    contentDescription = chipAction.descriptionTrailing,
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
        }
    )

}