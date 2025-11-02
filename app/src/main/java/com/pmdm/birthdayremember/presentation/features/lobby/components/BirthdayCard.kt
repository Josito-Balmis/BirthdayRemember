package com.pmdm.birthdayremember.presentation.features.lobby.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import com.pmdm.birthdayremember.presentation.components.globalvalues.MAX_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.model.EventDetails
import com.pmdm.birthdayremember.presentation.model.EventUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme
import java.time.LocalDate

@Composable
fun BirthdayCard(birthday: EventUiState) {
    Card(
        Modifier
            .padding(MIN_DP)
            .fillMaxWidth()
    ) {
        Box(Modifier.padding(MAX_DP)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Image(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Filled.PersonPin,
                    contentDescription = "Generic icon from birthday person"
                )

                Column {
                    Text(birthday.name)

                    Spacer(Modifier.padding(MIN_DP))

                    Text("${birthday.formattedDate()} - Cumple $ años.")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBirthdayCard() {
    BirthDayTheme {
        val fecha = LocalDate.of(2003, 2, 3)

        BirthdayCard(
            EventUiState(
                groupUiState = GroupUiState(),
                name = "Yusep",
                eventDetails = EventDetails(),
                date = fecha,
                hasYear = true,
                notes = "Me gustaria regalarle un nuevo piano.",
                image = null
            )
        )
    }
}