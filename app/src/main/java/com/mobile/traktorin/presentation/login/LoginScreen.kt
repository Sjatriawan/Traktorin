package com.mobile.traktorin.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.presentation.components.StandardTextField
import com.mobile.traktorin.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.presentation.ui.util.Screen


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = spaceLarge,
                end = spaceLarge,
                top = spaceLarge,
                bottom = 50.dp
            )
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ){
            Text(text = stringResource(id = R.string.intro),
                style= MaterialTheme.typography.h1,
            )
            Spacer(modifier = Modifier.height(spaceLarge))
            StandardTextField(text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsername(it)
                },
                error = viewModel.usernameError.value,
                hint = stringResource(id = R.string.login_hint)
            )

            Spacer(modifier = Modifier.height(spaceLarge))
            StandardTextField(text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPassword(it)
                },
                hint = stringResource(id = R.string.enter_your_password),
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value,
                error = viewModel.passwordError.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                },

                )

            Spacer(modifier = Modifier.height(spaceLarge))
            Button(
                onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation =  ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp,
              )
            ){
                Text(
                    text = stringResource(id = R.string.sign_in),
                    style = MaterialTheme.typography.h3

                )
            }

        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account))
                append(" ")
                val signupText = stringResource(id = R.string.sign_up)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ){
                    append(signupText)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )
    }

}