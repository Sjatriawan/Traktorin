package com.mobile.traktorin.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.traktorin.presentation.components.StandardScaffold
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun ProfileScreen(navController: NavController){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Profile Screen")
        }

}