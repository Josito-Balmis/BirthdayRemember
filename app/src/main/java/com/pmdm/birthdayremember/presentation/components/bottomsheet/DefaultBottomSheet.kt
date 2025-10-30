package com.pmdm.birthdayremember.presentation.components.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
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
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP

// Constants
private val START_PADD = 100.dp

// Main function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <Event> DefaultBottomSheetOptions(
    sheetState: SheetState,
    options: List<ItemAction<Event>>,
    onDismissRequest: () -> Unit,
    onClick: (Event) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                options.forEach { option ->
                    TextButton(
                        onClick = { onClick(option.event) },
                        Modifier.fillMaxWidth()
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(Modifier.padding(start = START_PADD))
                            Icon(option.icon ?: Icons.Default.BrokenImage, null)
                            Spacer(Modifier.padding(MIN_DP))
                            Text(option.name)
                        }
                    }
                }
            }
        }
    }
}