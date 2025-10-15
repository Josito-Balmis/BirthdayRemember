package com.pmdm.birthdayremember.presentation.features.eventcreator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import com.pmdm.birthdayremember.presentation.components.globalvalues.MID_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MIN_DP
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState

// Constants
private const val FONT_SIZE = 25F

// Composable Functions
@Composable
fun EventCard(
    groupUiState: GroupUiState
) {
    Card(Modifier.fillMaxWidth()) {
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
                    onClick = {}) {
                    Icon(Icons.TwoTone.Close, null)
                }
            }

            Spacer(Modifier.padding(MID_DP))


        }
    }
}

@Preview
@Composable
fun PreviewEventCard() {
    EventCard(
        groupUiState = GroupUiState(name = "Cumpleaños")
    )
}