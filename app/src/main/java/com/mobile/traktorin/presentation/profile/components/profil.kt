package com.mobile.traktorin.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Workspaces
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.domain.models.ProfileModel
import com.mobile.traktorin.presentation.ui.theme.Poppins
import com.mobile.traktorin.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    profileModel: ProfileModel
){
    Column(
        modifier.padding(spaceMedium)
    ) {
        Image(painterResource(
            id = R.drawable.postphoto),
            contentDescription ="Photo Profile" ,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Text(
            text = profileModel.username,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp
        )

    }
}

@Composable
fun Setting(
    navController: NavController,
    modifier: Modifier = Modifier,

){
    Column(
        modifier
            .fillMaxSize()
            .padding(spaceMedium),
        horizontalAlignment = Alignment.Start
    ) {
        SubMenu(
            text = "Pengaturan Akun",
            modifier = Modifier.padding(start = spaceMedium)
        )

        Spacer(modifier = Modifier.height(spaceMedium))
        ActionSetting(
            onClick = {
                      navController.navigate(Screen.EditProfileScreen.route)
            },
            nameSetting = "Informasi pribadi",
            icon = Icons.Outlined.Person
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(
                start = 5.dp,
                end = 30.dp,
                top = 15.dp,
                bottom = 15.dp
            )
        )
        Spacer(modifier = Modifier.height(3.dp))
        ActionSetting(
            nameSetting = "Pembayaran",
            icon = Icons.Outlined.Paid,
            onClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            },
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(
                start = 5.dp,
                end = 30.dp,
                top = 15.dp,
                bottom = 15.dp
            )
        )
        Spacer(modifier = Modifier.height(3.dp))

        ActionSetting(
            nameSetting = "Cara kerja",
            icon = Icons.Outlined.Workspaces,
            onClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            },
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(
                start = 5.dp,
                end = 30.dp,
                top = 15.dp,
                bottom = 15.dp
            )
        )
        Spacer(modifier = Modifier.height(3.dp))
    }
}


@Composable
fun ActionSetting(
    onClick: () -> Unit,
    nameSetting:String,
    iconSize: Dp = 28.dp,
    icon: ImageVector,
    modifier: Modifier = Modifier
){
    Row(modifier = Modifier
        .fillMaxWidth().clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            rememberVectorPainter(icon) ,
            contentDescription = "logout",
            modifier
                .padding(end = spaceMedium)
                .size(iconSize)
        )
        Text(
            text = nameSetting,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        )

    }
}


@Composable
fun SubMenu(
    text:String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    )
}