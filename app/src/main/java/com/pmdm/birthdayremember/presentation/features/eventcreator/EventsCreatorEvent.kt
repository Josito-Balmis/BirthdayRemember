package com.pmdm.birthdayremember.presentation.features.eventcreator

sealed interface EventsCreatorEvent {
    data class OnShowBottomSheet(val isShow: Boolean = false) : EventsCreatorEvent

}