package com.pmdm.birthdayremember.presentation.features.eventcreator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.birthdayremember.application.usecase.group.GetGroupsUseCase
import com.pmdm.birthdayremember.presentation.features.lobby.mapper.toListUi
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsCreatorVM @Inject constructor(
    private val getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {

    // Properties
    private val _listGroups = MutableStateFlow<List<GroupUiState>>(emptyList())
    val listGroups = _listGroups.asStateFlow()

    // Constructor
    init {
        viewModelScope.launch {
            loadListGroups()
        }
    }

    // Events
    fun onEventsCreatorEvent(eventsCreatorEvent: EventsCreatorEvent) {
        when (eventsCreatorEvent) {
            is EventsCreatorEvent.OnShowBottomSheet -> {}
        }
    }

    // Load Functions
    private suspend fun loadListGroups() {
        val result = getGroupsUseCase()

        result.onFailure {
            throw Exception("The group list couldn't be posible to load it")
        }.onSuccess {
            _listGroups.value = it.toListUi()
        }
    }

    // Encapsuled Functions

}