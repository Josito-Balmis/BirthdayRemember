package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Cake
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState

@Composable
fun ListBirthdays(
    listBirthdays: List<BirthdayUiState>
) {
    if (listBirthdays.isEmpty()) {
        ListEmptyScreen()
    } else
        LazyColumn(Modifier.fillMaxSize()) {
            items(items = listBirthdays, key = { it.id }) { birthday ->
                BirthdayCard(birthday)
            }
        }
}

@Composable
fun ListEmptyScreen() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "No hay eventos",
                fontFamily = FontFamily.Cursive,
                fontSize = 52.sp
            )

            Spacer(Modifier.padding(15.dp))

            Icon(
                imageVector = Icons.TwoTone.Cake,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

