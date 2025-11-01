package com.pmdm.birthdayremember.presentation.features.eventcreator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.twotone.Cake
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.github.pmdmiesbalmis.components.validacion.Validacion
import com.pmdm.birthdayremember.presentation.components.globalvalues.MAX_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MID_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.features.eventcreator.EventsCreatorEvent
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme
import java.time.LocalDate

// Constants
private const val FONT_SIZE = 25F
private val WIDTH_DAY = 85.dp
private val WIDTH_YEAR = 105.dp

// Composable Functions
@Composable
fun EventCard(
    groupUiState: GroupUiState,
    birthdayUiState: BirthdayUiState?,
    onEvent: (EventsCreatorEvent) -> Unit
) {
    Card(Modifier
        .fillMaxWidth()
        .padding(MAX_DP)) {
        Column(Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(start = MID_DP),
                    imageVector = Icons.TwoTone.Cake,
                    contentDescription = null
                )

                Spacer(Modifier.padding(MIN_DP))

                Text(
                    text = groupUiState.name,
                    fontSize = TextUnit(FONT_SIZE, TextUnitType.Sp),
                    modifier = Modifier.weight(1F)
                )

                IconButton(
                    onClick = { onEvent(EventsCreatorEvent.OnDeleteEvent) }) {
                    Icon(Icons.TwoTone.Close, null)
                }
            }

            Row(Modifier.align(Alignment.CenterHorizontally)) {
                TextFieldDate(
                    modifier = Modifier.widthIn(max = WIDTH_DAY),
                    date = birthdayUiState?.date?.dayOfMonth,
                    label = "Día",
                    validationState = MockValidation(false),
                    onValueChanged = { day ->
                        onEvent(
                            EventsCreatorEvent.OnDateChanged(
                                birthdayUiState?.date!!.withDayOfMonth(day)
                            )
                        )
                    }
                )

                Spacer(Modifier.padding(MID_DP))

                TextFieldDate(
                    modifier = Modifier.widthIn(max = WIDTH_DAY),
                    date = birthdayUiState?.date?.monthValue,
                    label = "Mes",
                    validationState = MockValidation(false),
                    onValueChanged = { month ->
                        onEvent(
                            EventsCreatorEvent.OnDateChanged(
                                birthdayUiState?.date!!.withMonth(month)
                            )
                        )
                    }
                )

                if (birthdayUiState?.hasYear == true) {
                    Spacer(Modifier.padding(MID_DP))

                    TextFieldDate(
                        modifier = Modifier.widthIn(max = WIDTH_YEAR),
                        date = birthdayUiState.date?.year,
                        label = "Año",
                        validationState = MockValidation(false),
                        onValueChanged = { year ->
                            onEvent(
                                EventsCreatorEvent.OnDateChanged(
                                    birthdayUiState.date!!.withYear(year)
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

// TEST FUNCTION FOR GET A MOCK VALIDATION
data class MockValidation(override val hayError: Boolean) : Validacion

@Preview
@Composable
fun PreviewEventCard() {
    BirthDayTheme {
        EventCard(
            groupUiState = GroupUiState(
                name = "Cumpleaños",
                id = 1,
                icon = Icons.Default.BrokenImage,
                isSelected = false,

                ),
            onEvent = {},
            birthdayUiState = BirthdayUiState().copy(date = LocalDate.now())
        )
    }
}

