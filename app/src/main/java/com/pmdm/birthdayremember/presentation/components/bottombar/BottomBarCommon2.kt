package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton

// T is for Actions
// U is for Floating Button

@Composable
fun <T, U> BottomBarCommon2(
    onClickAction: (T) -> Unit,
    onClickFloating: (U) -> Unit,
    actions: List<BottomBarAction<T>>,
    floatingAction: FloatingActionButton<U>
) {
    BottomAppBar(
        actions = {
            actions.forEach {
                IconButton(
                    onClick = { onClickAction(it.event) }
                ) {
                    Icon(imageVector = it.icon, it.description)
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