package com.pmdm.birthdayremember.presentation.features.eventcreator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.group.GetGroupsUseCase
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toListUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsCreatorVM @Inject constructor(
    private val getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {

    // Properties
    private val _uiState = MutableStateFlow(EventCreatorUiState())
    val uiState = _uiState.asStateFlow()

    // Constructor
    init {
        viewModelScope.launch {
            loadGroups()
        }
    }

    // Events
    fun onEventsCreatorEvent(onEventParam: EventsCreatorEvent) {
        when (onEventParam) {
            is EventsCreatorEvent.OnShowBottomSheet -> onShowBottomSheet(onEventParam)
            is EventsCreatorEvent.OnNameChanged -> onNameChanged(onEventParam)
            is EventsCreatorEvent.OnDeleteEvent -> {}
            is EventsCreatorEvent.OnSaveEvent -> {}
            is EventsCreatorEvent.OnDateChanged -> onDateChanged(onEventParam)
            is EventsCreatorEvent.OnAddGroup -> {}
            is EventsCreatorEvent.OnSelectGroup -> onSelectGroup(onEventParam)
        }
    }

    // Encapsuled Functions
    private fun onNameChanged(onEventParam: EventsCreatorEvent.OnNameChanged) {
        _uiState.update { currentState ->
            currentState.copy(name = onEventParam.name)
        }
    }

    private fun onDateChanged(onEventParam: EventsCreatorEvent.OnDateChanged) {
        _uiState.update {
            it.copy(birthdaySelected = it.birthdaySelected?.copy(date = onEventParam.date))
        }
    }

    private fun onShowBottomSheet(onEventParam: EventsCreatorEvent.OnShowBottomSheet) {
        _uiState.update {
            it.copy(showBottomSheet = onEventParam.isShow)
        }
    }

    private fun onSelectGroup(onEventParam: EventsCreatorEvent.OnSelectGroup) {
        _uiState.update {
            if (it.groupSelected?.id == onEventParam.id) return

            val groupSelected = it.listGroups.find { group -> group.id == onEventParam.id }
            it.copy(groupSelected = groupSelected)
        }
    }

    // Load functions
    private suspend fun loadGroups(){
        val result = getGroupsUseCase()

        result.onSuccess { listGroups ->
            _uiState.update { currentState ->
                currentState.copy(listGroups = listGroups.toListUi())
            }

        }
    }
}