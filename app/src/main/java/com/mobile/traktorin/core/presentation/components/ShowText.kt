package com.mobile.traktorin.core.presentation.components


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

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