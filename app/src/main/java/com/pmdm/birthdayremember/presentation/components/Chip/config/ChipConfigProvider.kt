package com.pmdm.birthdayremember.presentation.components.Chip.config

import com.pmdm.birthdayremember.presentation.components.Chip.ChipAction

interface ChipConfigProvider<T> {
    fun getChips(): List<ChipAction<T>>
}