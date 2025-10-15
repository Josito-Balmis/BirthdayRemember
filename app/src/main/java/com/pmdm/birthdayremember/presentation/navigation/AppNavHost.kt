package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorVM
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM

@Composable
fun AppNavHost(navHostController: NavHostController) {
    val lobbyVm = hiltViewModel<LobbyVM>()
    val eventCreatorVM = hiltViewModel<EventsCreatorVM>()

    NavHost(
        navController = navHostController,
        startDestination = LobbyRoute
    ) {
        displayLobbyDestination(
            vm = lobbyVm,
            onNavigateEventCreator = {
                navHostController.navigate(EventCreator)
            }
        )

        displayEventCreatorDestination(
            vm = eventCreatorVM
        )
    }
}