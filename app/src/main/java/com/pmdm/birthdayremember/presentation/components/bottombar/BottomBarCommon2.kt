package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton

// T is for Actions
// U is for Floating Button

@Composable
fun <Event1, Event2> BottomBarCommon2(
    onClickAction: (Event1) -> Unit,
    onClickFloating: (Event2) -> Unit,
    actions: List<BottomBarAction<Event1>>,
    floatingAction: FloatingActionButton<Event2>
) {
    BottomAppBar(
        actions = {
            actions.forEach {
                IconButton(
                    onClick = { onClickAction(it.event) }
                ) {
                    Icon(imageVector = it.icon, it.name)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onClickFloating(floatingAction.event) }
            ) {
                Icon(imageVector = floatingAction.icon, floatingAction.description)
            }
        }
    )
}