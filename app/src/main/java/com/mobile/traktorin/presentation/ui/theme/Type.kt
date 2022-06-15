package com.mobile.traktorin.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mobile.traktorin.R

val ReemKufi = FontFamily(
    Font(R.font.reemkufi_regular, FontWeight.Normal),
    Font(R.font.reemkufi_medium, FontWeight.Medium),
    Font(R.font.reemkufi_semibold, FontWeight.SemiBold),
    Font(R.font.reemkufi_bold, FontWeight.Bold),
)

val Quicksand = FontFamily(
    Font(R.font.quicksand_regular, FontWeight.Normal),
    Font(R.font.quicksand_medium, FontWeight.Medium),
    Font(R.font.quicksand_semibold, FontWeight.SemiBold),
    Font(R.font.quicksand_bold, FontWeight.Bold),
    )

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black
    ),

    body2 = TextStyle(
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = TextBlue
    ),



    h1 = TextStyle(
        fontFamily = ReemKufi,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = TextBlue
    ),

    h2 = TextStyle(
        fontFamily = ReemKufi,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = TextBlue
    ),

    h3 = TextStyle(
        fontFamily = ReemKufi,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),

    h4 = TextStyle(
        fontFamily = ReemKufi,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Gray
    ),

    h5 = TextStyle(
        fontFamily = ReemKufi,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    ),

    h6 = TextStyle(
        fontFamily = Quicksand,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
)