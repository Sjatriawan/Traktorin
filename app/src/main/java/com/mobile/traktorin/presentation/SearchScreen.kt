package com.mobile.traktorin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.domain.models.PostModel
import com.mobile.traktorin.presentation.components.Post
import com.mobile.traktorin.presentation.components.StandardToolbar
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun SearchScreen(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.SemiBold
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navAction = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Add")
                }
            }
        )
        Post(
            post = PostModel(
                imageUrl = "",
                locate = "Pogading, Lombok Timur",
                distance = "2 kilometer",
                price = "130 .000",
        ),
            onPostClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            }
        )
    }

}