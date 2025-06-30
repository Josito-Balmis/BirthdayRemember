package com.pmdm.birthdayremember.presentation.components.TopBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> TopBarCommon(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    actions: List<TopBarAction<T>>,
    onlick: (T) -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {}, //Possible left-menu
        actions = {
            actions.forEach {
                IconButton(
                    content = {
                        Icon(imageVector = it.icon, contentDescription = it.description)
                    },
                    enabled = it.enabled,
                    onClick = { onlick(it.event) }
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

