package com.pmdm.birthdayremember.presentation.features.eventcreator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person3
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.presentation.components.globalvalues.MAX_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MID_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.features.eventcreator.components.EventCard
import com.pmdm.birthdayremember.presentation.features.eventcreator.components.EventCreatorBottomSheet
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme

// Constants
private val TOP_PADD = 32.dp
private val IMAGE_SIZE = 150.dp
private val LAZYCOLUMN_HEIGHT = 300.dp

// Composable Functions
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCreatorScreen(
    eventCreatorUiState: EventCreatorUiState,
    onEvent: (EventsCreatorEvent) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = TOP_PADD),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Image(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(IMAGE_SIZE)
                )

                Spacer(Modifier.padding(MID_DP))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {}) {
                        Text("Avatar")
                    }

                    Button(onClick = {}) {
                        Text("Foto")
                    }
                }
            }
        }

        Spacer(Modifier.padding(MID_DP))

        Column(Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = MID_DP, end = MID_DP),
                leadingIcon = {
                    Icon(Icons.Outlined.Person3, null)
                },
                value = eventCreatorUiState.name,
                onValueChange = { name ->
                    onEvent(EventsCreatorEvent.OnNameChanged(name))
                },
                placeholder = {
                    Text("Nombre de la persona")
                }
            )

            Spacer(Modifier.padding(MID_DP))

            LazyColumn(Modifier.fillMaxWidth().height(LAZYCOLUMN_HEIGHT)) {
                items(items = eventCreatorUiState.listBirthdays, key = { it.id }
                ) { birthdayUiState ->
                    EventCard(
                        groupUiState = eventCreatorUiState.groupSelected!!,
                        onEvent = onEvent,
                        birthdayUiState = birthdayUiState
                    )
                }
            }

            Spacer(Modifier.padding(MID_DP))

            TextButton(onClick = { onEvent(EventsCreatorEvent.OnShowBottomSheet(isShow = true)) }) {
                Icon(Icons.TwoTone.AddCircle, null)
                Spacer(Modifier.padding(MIN_DP))
                Text("Añadir evento")
            }

            Button(
                onClick = { onEvent(EventsCreatorEvent.OnSaveEvent(birthdayUiState = eventCreatorUiState.birthdaySelected!!)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MAX_DP)
            ) {
                Text("Guardar")
            }
        }

        if (eventCreatorUiState.showBottomSheet) {
            EventCreatorBottomSheet(
                options = eventCreatorUiState.listGroups,
                onEvent = onEvent,
                sheetState = sheetState
            )
        }
    }
}

@Preview
@Composable
fun PreviewEventCreator() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            EventCreatorScreen(
                onEvent = {},
                eventCreatorUiState = EventCreatorUiState(),

                )
        }
    }
}