package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState

@Composable
fun ListBirthdays(
    listBirthdays: List<BirthdayUiState>
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(items = listBirthdays, key = { it.id }) { birthday ->
            BirthdayCard(birthday)
        }
    }
}