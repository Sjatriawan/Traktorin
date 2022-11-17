package com.mobile.traktorin.feature_profile.presentation.edit_profile
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.StandarTextFieldState
import com.mobile.traktorin.core.presentation.components.StandardTextField
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.feature_profile.presentation.profile.components.SubMenu
import com.mobile.traktorin.core.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall

@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel = hiltViewModel()
){
   Column(
       modifier = Modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState())
   ) {
       StandardToolbar(
           navController = navController,
           showBackArrow = true,
           title = {
               Text(stringResource(id = R.string.edit_profile))
           },
           navAction = {
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(
                      imageVector = Icons.Default.Check,
                      contentDescription = "check")
              }
           }
       )
       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(spaceLarge)
       ) {
           SubMenu(stringResource(id = R.string.edit_profile2),
               modifier = Modifier.align(Start))
           Spacer(modifier = Modifier.height(spaceLarge))
           Text(text = stringResource(id = R.string.username),
               style= MaterialTheme.typography.h3,
               textAlign = TextAlign.Start,
               modifier = Modifier.align(Alignment.Start)
           )
           StandardTextField(
               modifier = Modifier.padding(10.dp),
               text = viewModel.usernameState.value.text,
               error = viewModel.usernameState.value.error,
               shape = RoundedCornerShape(spaceSmall)
           ) {
               viewModel.setUsernameState(
                   StandarTextFieldState(text = it)
               )

           }

           Spacer(modifier = Modifier.height(spaceLarge))
           Text(text = stringResource(id = R.string.address),
               style= MaterialTheme.typography.h3,
               textAlign = TextAlign.Start,
               modifier = Modifier.align(Alignment.Start)

           )
           StandardTextField(
               modifier = Modifier.padding(10.dp),
               text = viewModel.addressState.value.text,
               error = viewModel.addressState.value.error,
               shape = RoundedCornerShape(spaceSmall)
           ) {
               viewModel.setAddressState(
                   StandarTextFieldState(text = it)
               )

           }

           Spacer(modifier = Modifier.height(spaceLarge))
           Text(text = stringResource(id = R.string.phone_number),
               style= MaterialTheme.typography.h3,
               textAlign = TextAlign.Start,
               modifier = Modifier.align(Alignment.Start)
           )
           StandardTextField(
               modifier = Modifier.padding(10.dp),
               text = viewModel.phoneNumber.value.text,
               error = viewModel.phoneNumber.value.error,
               shape = RoundedCornerShape(spaceSmall),
               keyboardType = KeyboardType.Number
           ) {
               viewModel.setNumberState(
                   StandarTextFieldState(text = it)
               )
           }

       }

   }
}

@Preview(showBackground = true)
@Composable
fun editProfileView(){
    EditProfileScreen(navController = rememberNavController( ))
}
