package com.mobile.traktorin.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Pink,
    background = Sky_blue,
    onBackground = Blue,
    onPrimary = DarkBlue,
    onSecondary = Color.Black,
    surface = Gray

)


@Composable
fun TraktorinTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}