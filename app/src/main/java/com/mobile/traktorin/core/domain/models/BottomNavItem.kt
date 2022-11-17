package com.mobile.traktorin.core.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route:String,
    val icon: ImageVector,
    val contentDescription:String? = null,
    val label:String? = null
)
