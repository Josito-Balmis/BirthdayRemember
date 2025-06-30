package com.pmdm.birthdayremember.presentation.features.lobby

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.twotone.CardGiftcard
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.FilterAlt
import androidx.compose.material.icons.twotone.Pix
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import com.pmdm.birthdayremember.presentation.components.Chip.ChipAction
import com.pmdm.birthdayremember.presentation.components.Chip.ChipCommon
import com.pmdm.birthdayremember.presentation.components.TopBar.TopBarAction
import com.pmdm.birthdayremember.presentation.components.TopBar.TopBarCommon
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.theme.BirthDayTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Constants
private val MIN_DP = 5.dp

//Main Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyScreen(
    listChipActions: List<ChipAction<LobbyEvent>>,
    listBirthdays: List<BirthdayUiState>
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            val listTopBarActions = buildTopBarActions()

            TopBarCommon(
                scrollBehavior = scrollBehavior,
                actions = listTopBarActions,
            )
        }
    ) {
        Surface(Modifier.padding(it)) {
            Column(Modifier.fillMaxWidth()) {
                FilterGroupFromChip(
                    listChipActions = listChipActions
                )

                ListBirthdays(listBirthdays)
            }
        }
    }
}

@Preview
@Composable
fun PreviewLobbyScreen() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            LobbyScreen(
                listChipActions = listOf(),
                listBirthdays = listOf()
            )
        }
    }
}

// Encapsulation composables functions
@Composable
fun FilterGroupFromChip(
    listChipActions: List<ChipAction<LobbyEvent>>
) {
    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {
        listChipActions.forEach { chipAction ->
            ChipCommon(
                chipAction = chipAction,
            )

            Spacer(Modifier.padding(MIN_DP))
        }
    }
}

@Preview
@Composable
fun PreviewFilterGroupByChip() {
    BirthDayTheme {
        Surface(Modifier.fillMaxSize()) {
            FilterGroupFromChip(
                listChipActions = listOf(
                    ChipAction(
                        text = "Cumpleaños",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Check,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = {},
                        enabled = true,
                    ),
                    ChipAction(
                        text = "Aniversario",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Pix,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = {},
                        enabled = false
                    ),
                    ChipAction(
                        text = "Fallecimiento",
                        iconAvatar = Icons.TwoTone.CardGiftcard,
                        iconTrailing = Icons.TwoTone.Pix,
                        descriptionAvatar = null,
                        descriptionTrailing = null,
                        onClick = {},
                        enabled = false
                    ),
                )
            )
        }
    }
}

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

                Text("${dateFormat(birthday)} - Cumple $ años.")
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


@Composable
fun ChooseTypeImage(modifier: Modifier, image: String?) {
    if (image == null)
        Image(
            modifier = modifier,
            imageVector = Icons.Filled.PersonPin,
            contentDescription = "Generic icon from birthday person"
        )

}

fun dateFormat(birthday: BirthdayUiState): String {
    val formatWithYear = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatWithoutYear = DateTimeFormatter.ofPattern("dd/MM")

    if (birthday.hasYear)
        return birthday.date.format(formatWithYear)

    return birthday.date.format(formatWithoutYear)
}

fun buildTopBarActions(): List<TopBarAction> =
    listOf(
        TopBarAction(
            icon = Icons.TwoTone.Search,
            description = "Birthday seeker",
            action = {}
        ),

        TopBarAction(
            icon = Icons.TwoTone.FilterAlt,
            description = "Birthday filter",
            action = {}
        ),
    )
