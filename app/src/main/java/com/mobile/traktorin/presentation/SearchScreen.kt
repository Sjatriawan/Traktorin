package com.mobile.traktorin.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mobile.traktorin.domain.models.PostModel
import com.mobile.traktorin.presentation.components.Post
import com.mobile.traktorin.presentation.components.StandardScaffold

@Composable
fun SearchScreen(
    navController: NavController
){
    Post(post = PostModel(
            imageUrl = "",
            locate = "Pogading, Lombok Timur",
            distance = "2 kilometer",
            price = "130.000"
    ))
}