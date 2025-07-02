package com.pmdm.birthdayremember.presentation.features.lobby

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.birthday.GetListBirthdaysUseCase
import com.pmdm.birthdayremember.application.usecase.group.GetGroupUseCase
import com.pmdm.birthdayremember.application.usecase.group.GetGroupsUseCase
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.components.topbar.TopBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyBottomBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.config.lobbyTopBarActionsConfig
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toListUi
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toUi
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState
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
    private val _listBirthdays = MutableStateFlow<List<BirthdayUiState>>(emptyList())
    val birthdays = _listBirthdays.asStateFlow()

    private val _listGroups = MutableStateFlow<List<GroupUiState>>(emptyList())
    val listGroups = _listGroups.asStateFlow()

    private val _listTopBarActions = MutableStateFlow<List<TopBarAction<LobbyEvent>>>(emptyList())
    val listTopBarActions = _listTopBarActions.asStateFlow()

    private val _listBottomBarActions = MutableStateFlow<List<BottomBarAction<LobbyEvent>>>(
        emptyList()
    )
    val listBottomBarAction = _listBottomBarActions.asStateFlow()

    private val _groupSelectedUiState = MutableStateFlow(GroupUiState())
    val groupSelectedUiState = _groupSelectedUiState.asStateFlow()

    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet = _showBottomSheet.asStateFlow()

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
            is LobbyEvent.OnNavigateCalendar -> {}
            is LobbyEvent.OnNavigateLobby -> {}
            is LobbyEvent.OnCreateBirthday -> {}
            is LobbyEvent.OnShowCreateEvent -> onShowCreateEvent(lobbyEvent)
        }
    }

    private fun onSelectGroup(event: LobbyEvent.OnSelectGroup) {
        // Update an element of our listGroup, in specific the isSelected
        _listGroups.update {
            it.map { groupUi ->
                if (groupUi.id == event.groupId && groupUi.isSelected.not())
                    groupUi.copy(isSelected = true)
                else groupUi.copy(isSelected = false)
            }
        }

        // Found the group selected and asign his value to the atribute
        _groupSelectedUiState.value = _listGroups.value.find {
            it.isSelected
        } ?: GroupUiState()
    }

    private fun onButtonFilter() {

    }

    private fun onButtonSearch() {

    }

    private fun onShowCreateEvent(event: LobbyEvent.OnShowCreateEvent) {
        _showBottomSheet.value = event.isShow
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

    private suspend fun loadListGroups() {
        val result = getGroupsUseCase()

        result.onSuccess {
            _listGroups.value = it.toListUi()
        }
    }

    private fun loadTopBarActions() {
        _listTopBarActions.value = lobbyTopBarActionsConfig()
    }

    private fun loadBottomBarActions() {
        _listBottomBarActions.value = lobbyBottomBarActionsConfig()
    }

    private fun loadGroupUiState(idGroup: Int) {
        viewModelScope.launch {
            val result = getGroupUseCase(idGroup)

            result.onFailure {
                Log.e(this.javaClass.name, it.message!!)
            }.onSuccess { group ->
                _groupSelectedUiState.value = group.toUi()
            }
        }
    }

    // Encapsulation functions

}