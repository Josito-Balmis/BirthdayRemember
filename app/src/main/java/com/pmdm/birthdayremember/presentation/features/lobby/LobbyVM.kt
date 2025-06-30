package com.pmdm.birthdayremember.presentation.features.lobby

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.birthday.GetListBirthdaysUseCase
import com.pmdm.birthdayremember.presentation.components.Chip.ChipAction
import com.pmdm.birthdayremember.presentation.config.ChipConfigProvider
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LobbyVM @Inject constructor(
    private val getListBirthdaysUseCase: GetListBirthdaysUseCase,
    private val lobbyChipConfigProvider: ChipConfigProvider<LobbyEvent>
) : ViewModel() {

    // Constructors
    init {
        viewModelScope.launch {
            loadBirthdays()
        }
        loadChipActions()
    }

    // Properties
    private val _listBirthdays = MutableStateFlow<List<BirthdayUiState>>(emptyList())
    val birthdays: StateFlow<List<BirthdayUiState>> = _listBirthdays.asStateFlow()

    private val _listChipAction = MutableStateFlow<List<ChipAction<LobbyEvent>>>(emptyList())
    val listChipAction: StateFlow<List<ChipAction<LobbyEvent>>> = _listChipAction.asStateFlow()

    // Events
    fun onLobbyEvent(lobbyEvent: LobbyEvent) {
        when (lobbyEvent) {
            is LobbyEvent.OnSelectGroup -> TODO()
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
        _listChipAction.update {
            lobbyChipConfigProvider.getChips { event ->
                onLobbyEvent(event)
            }
        }
    }
}