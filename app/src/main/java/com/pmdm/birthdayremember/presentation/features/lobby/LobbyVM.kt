package com.pmdm.birthdayremember.presentation.features.lobby

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.birthday.GetListBirthdaysUseCase
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.components.chip.config.ChipConfigProvider
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyBottomBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyTopBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toListUi
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LobbyVM @Inject constructor(
    private val getListBirthdaysUseCase: GetListBirthdaysUseCase,
    private val lobbyChipConfigProvider: ChipConfigProvider<LobbyEvent>
) : ViewModel() {

    // Properties
    private val _listBirthdays = MutableStateFlow<List<BirthdayUiState>>(emptyList())
    val birthdays: StateFlow<List<BirthdayUiState>> = _listBirthdays.asStateFlow()

    private val _listChipActions = MutableStateFlow<List<ChipAction<LobbyEvent>>>(emptyList())
    val listChipActions: StateFlow<List<ChipAction<LobbyEvent>>> = _listChipActions.asStateFlow()

    private val _listTopBarActions = MutableStateFlow<List<TopBarAction<LobbyEvent>>>(emptyList())
    val listTopBarActions: StateFlow<List<TopBarAction<LobbyEvent>>> =
        _listTopBarActions.asStateFlow()

    private val _listBottomBarActions = MutableStateFlow<List<BottomBarAction<LobbyEvent>>>(
        emptyList()
    )
    val listBottomBarAction: StateFlow<List<BottomBarAction<LobbyEvent>>> =
        _listBottomBarActions.asStateFlow()

    // Constructors
    init {
        viewModelScope.launch {
            loadTopBarActions()
            loadBottomBarActions()
            loadChipActions()
            loadBirthdays()
        }
    }

    // Events
    fun onLobbyEvent(lobbyEvent: LobbyEvent) {
        when (lobbyEvent) {
            is LobbyEvent.OnSelectGroup -> {}
            LobbyEvent.OnButtonFilter -> {}
            LobbyEvent.OnButtonSearch -> {}
            LobbyEvent.OnNavigateCalendar -> {}
            LobbyEvent.OnNavigateLobby -> {}
            LobbyEvent.OnCreateBirthday -> {}
        }
    }

    // Load Functions
    private suspend fun loadBirthdays() {
        val result = getListBirthdaysUseCase()

        result
            .onFailure {
                Log.e(this.javaClass.name, "Failed to load the list of birthdays.")
            }.onSuccess { birthdays ->
                _listBirthdays.value = birthdays.toListUi()
            }
    }

    private fun loadChipActions() {
        _listChipActions.value = lobbyChipConfigProvider.getChips()
    }

    private fun loadTopBarActions() {
        _listTopBarActions.value = lobbyTopBarActionsConfig()
    }

    private fun loadBottomBarActions() {
        _listBottomBarActions.value = lobbyBottomBarActionsConfig()
    }
}