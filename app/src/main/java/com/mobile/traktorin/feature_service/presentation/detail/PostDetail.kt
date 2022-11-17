package com.mobile.traktorin.feature_service.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.Detail
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall

@Composable
fun PostDetail(
    navController: NavController,
    post:Detail,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(painterResource(
            id = R.drawable.postphoto),
            contentDescription = "Feed",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(spaceSmall))
        Text(
            text = post.merk,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(spaceSmall))
        Text(
            text = post.locate,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 30.dp)
            )
        Spacer(modifier = Modifier.height(spaceSmall))
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
        )

        Text(
            text = post.service_by,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(start = 30.dp)
        )

        Spacer(modifier = Modifier.height(spaceSmall))
        Text(
            text = post.name,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(spaceSmall))
        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp))
    }

}




