package com.mobile.traktorin.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mobile.traktorin.R
import com.mobile.traktorin.domain.models.Detail
import com.mobile.traktorin.domain.models.PostModel
import com.mobile.traktorin.presentation.detail.PostDetail
import com.mobile.traktorin.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.presentation.ui.theme.spaceMedium


@Composable
fun Post(
    post: PostModel,
    onPostClick:() -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spaceMedium)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color.White)
                .clickable {
                    onPostClick()
                }
        ){
            Image(painterResource(
                id = R.drawable.postphoto),
                contentDescription = "Feed",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(spaceMedium))
            Text(

                text = post.locate,
                style = MaterialTheme.typography.h5
            )

            Text(
                text = post.distance,
                style = MaterialTheme.typography.h6
            )

            Text(
                text = post.price,
                style = MaterialTheme.typography.h5
            )
        }


    }
}


