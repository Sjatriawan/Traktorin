package com.mobile.traktorin.feature_favorite.presentation.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall

@Composable
fun FavoriteScreen(
    navController: NavController,
){
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spaceSmall)
        ){
            StandardToolbar(
                navController = navController,
                title = {
                        Text(
                            text = stringResource(id = R.string.title_favorit),
                            color = Color.Black
                        )
                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = true
            )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ){
            items(20) {
                FavoriteItem(
                    favorite = Favorite(
                        imageUrl = "", 
                        username = "Mama", 
                        timestamp = System.currentTimeMillis()
                    ),
                )
            }
        }
        }

}