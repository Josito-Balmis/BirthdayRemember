package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventCreatorScreen
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorVM
import kotlinx.serialization.Serializable

@Serializable
data object EventCreatorRoute

fun NavGraphBuilder.displayEventCreatorDestination() {
    composable<EventCreatorRoute> {
        val vm = hiltViewModel<EventsCreatorVM>()

        val listGroups by vm.listGroups.collectAsStateWithLifecycle()
        val birthdayUiState by vm.birthdayUiState.collectAsStateWithLifecycle()

        EventCreatorScreen(
            listGroups = listGroups,
            birthdayUiState = birthdayUiState,
            onEvent = vm::onEventsCreatorEvent
        )
    }
}