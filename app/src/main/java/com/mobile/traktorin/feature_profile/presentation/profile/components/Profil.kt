package com.mobile.traktorin.feature_profile.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Workspaces
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.ProfileModel
import com.mobile.traktorin.core.domain.models.User
import com.mobile.traktorin.core.presentation.ui.theme.Poppins
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.util.Screen

@Composable
fun ProfileItem(
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
            Image(painterResource(
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
                text = stringResource(id = R.string.village_example),
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(),
                text = stringResource(id = R.string.coma),
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(),
                text = stringResource(id = R.string.district_example),
                fontSize = 16.sp
            )
        }
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
                      navController.navigate(Screen.DetailFeedScreen.route)
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
        Spacer(modifier = Modifier.height(5.dp))

        SubMenu(
            text = "Menjadi pembajak sawah?",
            modifier = Modifier.padding(start = spaceMedium)
        )

        Spacer(modifier = Modifier.height(spaceMedium))
        ActionSetting(
            onClick = {
                navController.navigate(Screen.CreateServiceScreen.route)
            },
            nameSetting = "Siapkan penawaran anda",
            icon = Icons.Outlined.Person
        )
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
        .fillMaxWidth()
        .clickable(onClick = onClick),
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