package com.mobile.traktorin.feature_profile.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.ProfileModel
import com.mobile.traktorin.core.domain.models.User
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    user: User,
    isOwnProfileModel: Boolean = true,
    onEditClick:() -> Unit = {}
){
    Column(
        modifier.fillMaxSize().padding(spaceMedium)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(
                id = R.drawable.postphoto),
                contentDescription ="Photo Profile" ,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = user.username,
                fontSize = 24.sp
            )
        }

        Row(modifier.fillMaxWidth().padding(top = 10.dp)) {
            Text(
                modifier = Modifier.padding(),
                text = user.village,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(),
                text = stringResource(id = R.string.coma),
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(),
                text = user.district,
                fontSize = 16.sp
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ComposablePreview() {
    ProfileSection(
        user = User(
            userId = "ASU",
            userPhone = 0,
            username = "ASI",
            district = "ASU",
            province = "ASU",
            village = "ASU",
            email = "ASU",
            profileImgUrl = "ASU",)
    )
}
