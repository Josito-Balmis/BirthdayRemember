package com.pmdm.birthdayremember.presentation.features.eventcreator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person3
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButtonMenu
import androidx.compose.material3.FloatingActionButtonMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.ToggleFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.presentation.components.globalvalues.MAX_DP
import com.pmdm.birthdayremember.presentation.components.globalvalues.MID_DP
import com.pmdm.birthdayremember.presentation.features.eventcreator.components.EventCard
import com.pmdm.birthdayremember.presentation.features.lobby.model.GroupUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme

// Constants
private val TOP_PADD = 32.dp
private val IMAGE_SIZE = 150.dp

// Composable Functions
@Composable
fun EventCreatorScreen(
    listEvents: List<GroupUiState>
) {
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
                value = "",
                onValueChange = {},
                placeholder = {
                    Text("Nombre de la persona")
                }
            )

            Spacer(Modifier.padding(MID_DP))

            LazyColumn {
                items(items = listEvents, key = { it.id }
                ) { groupUiState ->
                    EventCard(groupUiState)
                }
            }

            Spacer(Modifier.padding(MID_DP))

            TextButton(onClick = {}) {
                Icon(Icons.TwoTone.AddCircle, null)
                Text("Añadir evento")
            }

            Button(
                onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(MAX_DP)
            ) {
                Text("Guardar")
            }
        }

    }

}

@Preview
@Composable
fun PreviewEventCreator() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            EventCreatorScreen(
                listEvents = listOf()
            )
        }
    }
}

// This is a test of Material Design Expressive

//@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//fun FloatingActionButtonMenuSample() {
//    var fabMenuExpanded by rememberSaveable { mutableStateOf(false) }
//
//    FloatingActionButtonMenu(
//        expanded = fabMenuExpanded,
//        button = {
//            ToggleFloatingActionButton(
//                checked = fabMenuExpanded,
//                onCheckedChange = { fabMenuExpanded = it }
//            ) {
//                Icon(
//                    if (fabMenuExpanded) Icons.Default.Close else Icons.Default.Add,
//                    contentDescription = null
//                )
//            }
//        }
//    ) {
//        FloatingActionButtonMenuItem(
//            icon = { Icon(Icons.Default.Edit, contentDescription = "Editar") },
//            onClick = { },
//            text = {
//                Text("Editar")
//            }
//        )
//
//        FloatingActionButtonMenuItem(
//            icon = { Icon(Icons.Default.Edit, contentDescription = "Editar") },
//            onClick = { },
//            text = {
//
//            }
//        )
//
//        FloatingActionButtonMenuItem(
//            icon = { Icon(Icons.Default.Edit, contentDescription = "Editar") },
//            onClick = { },
//            text = {}
//        )
//
//    }
