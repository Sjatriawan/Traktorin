package com.mobile.traktorin.core.presentation.components


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun ShowText(
    text: String,
    style: TextStyle,
    modifier: Modifier
) {
    Text(
        text = text,
        style = style,
        modifier = modifier
    )
}