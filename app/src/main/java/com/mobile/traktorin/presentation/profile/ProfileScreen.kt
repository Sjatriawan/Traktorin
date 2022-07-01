package com.mobile.traktorin.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

import com.mobile.traktorin.domain.models.ProfileModel

import com.mobile.traktorin.presentation.profile.components.ProfileItem
import com.mobile.traktorin.presentation.profile.components.Setting
import com.mobile.traktorin.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun ProfileScreen(
    navController: NavController,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spaceSmall)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ){
            item{
                ProfileItem(profileModel = ProfileModel(
                    username = "Satriawan",
                    imageUrl = ""
                ))
            }
        }
        Setting()
    }
}
