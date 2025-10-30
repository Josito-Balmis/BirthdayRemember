package com.pmdm.birthdayremember.presentation.navigation

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

        val eventCreatorUiState by vm.uiState.collectAsStateWithLifecycle()

        EventCreatorScreen(
            eventCreatorUiState = eventCreatorUiState,
            onEvent = vm::onEventsCreatorEvent,
        )
    }
}