

package com.mobile.traktorin.feature_profile.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi

import com.mobile.traktorin.core.domain.models.ProfileModel
import com.mobile.traktorin.core.domain.models.User

import com.mobile.traktorin.feature_profile.presentation.profile.components.ProfileItem
import com.mobile.traktorin.feature_profile.presentation.profile.components.Setting
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.feature_profile.domain.model.Profile
import com.mobile.traktorin.feature_profile.presentation.profile.components.ProfileSection


@ExperimentalCoilApi
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel(),
){
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spaceSmall)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ){
            item{
                state.profile?.let { profile ->
                    ProfileSection(
                        user = User(
                            userId = profile.username,
                            userPhone = profile.userPhone,
                            username = profile.username,
                            district = profile.district,
                            province = profile.province,
                            village = profile.village,
                            email = profile.village,
                            profileImgUrl = profile.profileImgUrl,
                        ),
                        isOwnProfileModel = profile.isOwnProfile,
                    )

                }
            }
           item {
               Setting(navController = navController)
           }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Preview(showBackground = true)
@Composable
fun ComposePreview(){
    ProfileScreen(navController = rememberNavController())
}


