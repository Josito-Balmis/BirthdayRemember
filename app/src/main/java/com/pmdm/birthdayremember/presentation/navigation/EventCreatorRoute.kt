package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventCreatorScreen
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorVM
import kotlinx.serialization.Serializable

@Serializable
data object EventCreatorRoute

fun NavGraphBuilder.displayEventCreatorDestination(
    vm: EventsCreatorVM
){
    composable<EventCreatorRoute> {
        val listEvents by vm.listGroups.collectAsState()

        EventCreatorScreen(
            listEvents = listEvents
        )
    }
}