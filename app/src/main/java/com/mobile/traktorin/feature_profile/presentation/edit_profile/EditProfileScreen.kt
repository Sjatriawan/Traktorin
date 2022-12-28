package com.mobile.traktorin.feature_profile.presentation.edit_profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.feature_profile.presentation.profile.components.SubMenu
import com.mobile.traktorin.core.presentation.ui.theme.spaceLarge

@Composable
fun EditProfileScreen(
    navController: NavController,
//    viewModel: EditProfileViewModel = hiltViewModel(),
    profilePictureSize: Dp = 24.dp
){
   Column(
       modifier = Modifier
           .fillMaxSize()
   ) {
       StandardToolbar(
           showBackArrow = true,
           navAction = {
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(
                      imageVector = Icons.Default.Check,
                      contentDescription = "check")
              }
           },
           title = {
               Text(stringResource(id = R.string.edit_profile))
           }
       )
       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(spaceLarge).verticalScroll(rememberScrollState())
       ) {
           SubMenu(stringResource(id = R.string.edit_profile2),
               modifier = Modifier.align(Start))
           Spacer(modifier = Modifier.height(spaceLarge))
           Image(
               painterResource(
               id = R.drawable.postphoto),
               contentDescription ="Photo_Profile" ,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .size(64.dp)
                   .clip(CircleShape)
           )

//           Spacer(modifier = Modifier.height(spaceLarge))
//           Text(text = stringResource(id = R.string.username),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.usernameState.value.text,
//               error = viewModel.usernameState.value.error,
//               shape = RoundedCornerShape(spaceSmall)
//           ) {
//               viewModel.setUsernameState(
//                   StandarTextFieldState(text = it)
//               )
//           }
//
//           Spacer(modifier = Modifier.height(spaceMedium))
//           Text(text = stringResource(id = R.string.email),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.emailState.value.text,
//               error = viewModel.emailState.value.error,
//               shape = RoundedCornerShape(spaceSmall)
//           ) {
//               viewModel.setEmailState(
//                   StandarTextFieldState(text = it)
//               )
//
//           }
//
//           Spacer(modifier = Modifier.height(spaceMedium))
//           Text(text = stringResource(id = R.string.village),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.villageState.value.text,
//               error = viewModel.villageState.value.error,
//               shape = RoundedCornerShape(spaceSmall)
//           ) {
//               viewModel.setVillageState(
//                   StandarTextFieldState(text = it)
//               )
//           }
//
//           Spacer(modifier = Modifier.height(spaceMedium))
//           Text(text = stringResource(id = R.string.district),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.districtState.value.text,
//               error = viewModel.districtState.value.error,
//               shape = RoundedCornerShape(spaceSmall)
//           ) {
//               viewModel.setDistrictState(
//                   StandarTextFieldState(text = it)
//               )
//
//           }
//
//           Spacer(modifier = Modifier.height(spaceMedium))
//           Text(text = stringResource(id = R.string.province),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.provinceState.value.text,
//               error = viewModel.provinceState.value.error,
//               shape = RoundedCornerShape(spaceSmall)
//           ) {
//               viewModel.setProvinceState(
//                   StandarTextFieldState(text = it)
//               )
//
//           }
//
//           Spacer(modifier = Modifier.height(spaceMedium))
//           Text(text = stringResource(id = R.string.phone_number),
//               style= MaterialTheme.typography.h3,
//               textAlign = TextAlign.Start,
//               modifier = Modifier.align(Alignment.Start)
//           )
//           StandardTextField(
//               modifier = Modifier.padding(10.dp),
//               text = viewModel.phoneNumber.value.text,
//               error = viewModel.phoneNumber.value.error,
//               shape = RoundedCornerShape(spaceSmall),
//               keyboardType = KeyboardType.Number
//           ) {
//               viewModel.setNumberState(
//                   StandarTextFieldState(text = it)
//               )
//           }

       }

   }
}
