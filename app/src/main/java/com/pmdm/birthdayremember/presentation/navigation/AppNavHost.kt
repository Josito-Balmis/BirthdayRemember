package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorVM
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyNavigationEvent
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = LobbyRoute
    ) {
        displayLobbyDestination(
            onNavigate = { event ->
                when (event) {
                    LobbyNavigationEvent.OnNavigateAddCategory -> {}
                    LobbyNavigationEvent.OnNavigateCalendar -> {}
                    LobbyNavigationEvent.OnNavigateImportContacts -> {}
                    LobbyNavigationEvent.OnNavigateLobby -> {}
                    LobbyNavigationEvent.OnNavigateAddEvent -> navHostController.navigate(
                        EventCreatorRoute
                    )
                }
            }
        )

        displayEventCreatorDestination()
    }
}