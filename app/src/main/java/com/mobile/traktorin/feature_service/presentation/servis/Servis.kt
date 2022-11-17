package com.mobile.traktorin.feature_service.presentation.servis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.traktorin.core.presentation.components.StandardScaffold

@Composable
fun ServisScreen(
    navController: NavController,
){
    val scaffoldState = rememberScaffoldState()
    StandardScaffold(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        state = scaffoldState,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Servis Screen")
        }
    }

}