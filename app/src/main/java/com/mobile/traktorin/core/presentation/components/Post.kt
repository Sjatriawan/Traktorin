package com.mobile.traktorin.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.PostModel
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium


@Composable
fun Post(
    modifier: Modifier = Modifier,
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


