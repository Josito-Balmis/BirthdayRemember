package com.pmdm.birthdayremember.presentation.features.eventcreator

import androidx.lifecycle.ViewModel
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EventsCreatorVM @Inject constructor(
    //private val getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {

    // Properties
    private val _listGroups = MutableStateFlow<List<GroupUiState>>(emptyList())
    val listGroups = _listGroups.asStateFlow()

    private val _birthdayState = MutableStateFlow(BirthdayUiState())
    val birthdayUiState = _birthdayState.asStateFlow()

    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet = _showBottomSheet.asStateFlow()

    // Constructor
//    init {
//        viewModelScope.launch {
//            //loadListGroups()
//        }
//    }

    // Events
    fun onEventsCreatorEvent(onEventParam: EventsCreatorEvent) {
        when (onEventParam) {
            is EventsCreatorEvent.OnShowBottomSheet -> onShowBottomSheet(onEventParam)
            is EventsCreatorEvent.OnNameChanged -> onNameChanged(onEventParam)
            is EventsCreatorEvent.OnDeleteEvent -> {}
            is EventsCreatorEvent.OnSaveEvent -> {}
            is EventsCreatorEvent.OnDateChanged -> onDateChanged(onEventParam)
            is EventsCreatorEvent.OnAddGroup -> {}
        }
    }


    // Load Functions
//    private suspend fun loadListGroups() {
//        val result = getGroupsUseCase()
//
//        result.onFailure {
//            throw Exception("The group list couldn't be posible to load it")
//        }.onSuccess {
//            _listGroups.value = it.toListUi()
//        }
//    }

    // Encapsuled Functions
    private fun onNameChanged(onEventParam: EventsCreatorEvent.OnNameChanged) {
        _birthdayState.update { currentState ->
            currentState.copy(name = onEventParam.name)
        }
    }

    private fun onDateChanged(onEventParam: EventsCreatorEvent.OnDateChanged) {
        _birthdayState.update { currentState ->
            currentState.copy(date = onEventParam.date)
        }
    }

    private fun onShowBottomSheet(onEventParam: EventsCreatorEvent.OnShowBottomSheet) {
        _showBottomSheet.update { onEventParam.isShow }
    }
}