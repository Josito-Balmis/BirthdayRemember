package com.pmdm.birthdayremember.presentation.features.eventcreator.components

import android.telephony.PhoneNumberUtils
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldWithErrorState
import com.github.pmdmiesbalmis.components.validacion.Validacion

@Composable
fun TextFieldDate(
    modifier: Modifier,
    date: Int?,
    label: String,
    validationState: Validacion,
    onValueChanged: (Int) -> Unit
) {
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        textoState = date?.toString() ?: "",
        textoPista = "Clue text; modify this text in the function",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        validacionState = validationState,
        label = label,
        onValueChange = {
            var text = it
            if (!validationState.hayError)
                text = PhoneNumberUtils.formatNumber(it, "ES")

            onValueChanged(text.toInt())
        }
    )

}

