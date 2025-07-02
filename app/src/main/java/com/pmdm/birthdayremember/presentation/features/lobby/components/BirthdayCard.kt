package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import com.pmdm.birthdayremember.presentation.features.lobby.MIN_DP
import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme
import java.time.LocalDate

@Composable
fun BirthdayCard(birthday: BirthdayUiState) {
    Card(
        Modifier
            .padding(MIN_DP)
            .fillMaxWidth()
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.align(Alignment.CenterStart),
                imageVector = Icons.Filled.PersonPin,
                contentDescription = "Generic icon from birthday person"
            )

            Spacer(Modifier.padding(MIN_DP))

            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(birthday.name)

                Spacer(Modifier.padding(MIN_DP))

                Text("${birthday.formattedDate()} - Cumple $ años.")
            }

        }
    }
}

@Preview
@Composable
fun PreviewBirthdayCard() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            val fecha = LocalDate.of(2003, 2, 3)

            BirthdayCard(
                BirthdayUiState(
                    idGroup = 1,
                    name = "Yusep",
                    zodiac = Zodiac.getZodiacSignByDate(fecha),
                    date = fecha,
                    hasYear = true,
                    notes = "Me gustaria regalarle un nuevo piano.",
                    image = null
                )
            )
        }
    }
}