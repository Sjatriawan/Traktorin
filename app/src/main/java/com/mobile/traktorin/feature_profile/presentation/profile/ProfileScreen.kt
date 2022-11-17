package com.mobile.traktorin.feature_profile.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

import com.mobile.traktorin.core.domain.models.ProfileModel

import com.mobile.traktorin.feature_profile.presentation.profile.components.ProfileItem
import com.mobile.traktorin.feature_profile.presentation.profile.components.Setting
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall

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
        Setting(navController = navController)
    }
}
