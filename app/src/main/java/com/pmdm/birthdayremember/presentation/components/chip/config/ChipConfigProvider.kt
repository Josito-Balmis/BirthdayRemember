package com.pmdm.birthdayremember.presentation.components.chip.config

import com.pmdm.birthdayremember.presentation.components.chip.ChipAction

interface ChipConfigProvider<T> {
    fun getChips(): List<ChipAction<T>>
}