package com.pmdm.birthdayremember.presentation.config

import com.pmdm.birthdayremember.presentation.components.Chip.ChipAction

interface ChipConfigProvider<T> {
    fun getChips(
        onClick: (T) -> Unit
    ): List<ChipAction<T>>
}