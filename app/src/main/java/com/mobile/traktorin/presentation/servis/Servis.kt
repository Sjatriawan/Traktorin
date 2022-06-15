package com.mobile.traktorin.presentation.servis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.traktorin.presentation.components.StandardScaffold

@Composable
fun ServisScreen(navController: NavController){
    StandardScaffold(
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Servis Screen")
        }
    }

}