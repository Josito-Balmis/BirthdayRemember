package com.pmdm.birthdayremember.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyScreen
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM
import kotlinx.serialization.Serializable

@Serializable
data object LobbyRoute

fun NavGraphBuilder.displayLobbyDestination(
    vm: LobbyVM
) {
    composable<LobbyRoute> {
        LobbyScreen(
            listChipActions = vm.listChipAction.value,
            listBirthdays = vm.birthdays.value
        )
    }
}