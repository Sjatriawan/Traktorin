package com.mobile.traktorin.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Search(
    hint: String = "",
    onValueChange:(String)-> Unit
){
    OutlinedTextField(
        value =hint,
        onValueChange = onValueChange,

        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.h4,
            )
        }
    )
}