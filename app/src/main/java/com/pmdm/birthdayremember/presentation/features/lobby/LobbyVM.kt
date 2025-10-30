package com.pmdm.birthdayremember.presentation.features.lobby

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.birthday.GetListBirthdaysUseCase
import com.pmdm.birthdayremember.application.usecase.group.GetGroupUseCase
import com.pmdm.birthdayremember.application.usecase.group.GetGroupsUseCase
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.chip.ChipAction
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyBottomBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyTopBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyNavigationEvent
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toListUi
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LobbyVM @Inject constructor(
    private val getListBirthdaysUseCase: GetListBirthdaysUseCase,
    private val getGroupsUseCase: GetGroupsUseCase,
    private val getGroupUseCase: GetGroupUseCase
) : ViewModel() {

    // Properties
    private val _uiState = MutableStateFlow(LobbyUiState())
    val uiState = _uiState.asStateFlow()

    private val _listTopBarActions = MutableStateFlow<List<TopBarAction<LobbyEvent>>>(emptyList())
    val listTopBarActions = _listTopBarActions.asStateFlow()

    private val _listBottomBarActions =
        MutableStateFlow<List<BottomBarAction<LobbyNavigationEvent>>>(
            emptyList()
        )
    val listBottomBarAction = _listBottomBarActions.asStateFlow()

    // Constructors
    init {
        viewModelScope.launch {
            loadTopBarActions()
            loadBottomBarActions()
            loadListGroups()
            loadBirthdays()
        }
    }

    // Events
    fun onLobbyEvent(lobbyEvent: LobbyEvent) {
        when (lobbyEvent) {
            is LobbyEvent.OnSelectGroup -> onSelectGroup(lobbyEvent)
            is LobbyEvent.OnButtonFilter -> onButtonFilter()
            is LobbyEvent.OnButtonSearch -> onButtonSearch()
            is LobbyEvent.OnShowBottomSheet -> onShowBottomSheet(lobbyEvent)
        }
    }

    private fun onSelectGroup(event: LobbyEvent.OnSelectGroup) {
        _uiState.update {
            if (_uiState.value.groupSelected?.id == event.groupId) {
                val updatedList = it.listGroups.map { group -> group.copy(isSelected = false) }

                it.copy(
                    listGroups = updatedList,
                    groupSelected = null
                )
            } else {
                val updatedList = it.listGroups.map { group ->
                    group.copy(isSelected = group.id == event.groupId)
                }

                val groupSelected = updatedList.find { it.isSelected }

                it.copy(
                    listGroups = updatedList,
                    groupSelected = groupSelected
                )
            }
        }
    }

    private fun onShowBottomSheet(event: LobbyEvent.OnShowBottomSheet) {
        _uiState.update {
            it.copy(showBottomSheet = event.isShow)
        }
    }

    private fun onButtonFilter() {

    }

    private fun onButtonSearch() {

    }

    // Load Functions
    private suspend fun loadBirthdays() {
        val result = getListBirthdaysUseCase()

        result
            .onFailure {
                Log.e(this.javaClass.name, "Failed to load the list of birthdays.")
            }.onSuccess { listBirthdays ->
                _uiState.update {
                    it.copy(listBirthdays = listBirthdays.toListUi())
                }
            }
    }

    private suspend fun loadListGroups() {
        val result = getGroupsUseCase()

        result.onSuccess { listGroups ->
            _uiState.update {
                it.copy(listGroups = listGroups.toListUi())
            }
        }
    }

    private fun loadTopBarActions() {
        _listTopBarActions.update {
            lobbyTopBarActionsConfig()
        }
    }

    private fun loadBottomBarActions() {
        _listBottomBarActions.update {
            lobbyBottomBarActionsConfig()
        }
    }

    private fun loadGroupSelected(idGroup: Int) {
        viewModelScope.launch {
            val result = getGroupUseCase(idGroup)

            result.onFailure {
                Log.e(this.javaClass.name, it.message!!)
            }.onSuccess { group ->
                _uiState.update {
                    it.copy(groupSelected = group.toUi())
                }
            }
        }
    }

// Encapsulation functions

}