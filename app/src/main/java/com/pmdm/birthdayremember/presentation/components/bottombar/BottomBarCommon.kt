package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.chip.ItemAction
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton

@Composable
fun <Event> BottomBarCommon(
    onClick: (Event) -> Unit,
    actions: List<ItemAction<Event>>,
    floatingAction: FloatingActionButton<Event>
) {
    BottomAppBar(
        actions = {
            actions.forEach {
                IconButton(
                    onClick = { onClick(it.event) }
                ) {
                    Icon(imageVector = it.icon ?: Icons.Default.BrokenImage, it.name)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onClick(floatingAction.event) }
            ) {
                Icon(imageVector = floatingAction.icon, floatingAction.description)
            }
        }
    )
}