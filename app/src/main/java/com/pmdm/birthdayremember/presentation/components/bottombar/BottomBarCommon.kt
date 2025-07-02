package com.pmdm.birthdayremember.presentation.components.bottombar

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.pmdm.birthdayremember.presentation.components.floatingbutton.FloatingActionButton

@Composable
fun <T> BottomBarCommon(
    onClick: (T) -> Unit,
    actions: List<BottomBarAction<T>>,
    floatingAction: FloatingActionButton<T>
) {

    BottomAppBar(
        actions = {
            actions.forEach {
                IconButton(
                    onClick = { onClick(it.event) }
                ) {
                    Icon(imageVector = it.icon, it.description)
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