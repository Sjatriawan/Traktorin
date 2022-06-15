package com.mobile.traktorin.presentation.regis

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
import com.mobile.traktorin.presentation.ui.theme.spaceMedium


@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = spaceLarge,
                end = spaceLarge,
                bottom = 30.dp
            )
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ){
            Text(text = stringResource(id = R.string.intro2),
                style= MaterialTheme.typography.h1,
            )
            Spacer(modifier = Modifier.height(spaceLarge))
            StandardTextField(text = viewModel.emailText.value,
                onValueChange = {
                    viewModel.setEmail(it)
                },
                error = viewModel.emailError.value,
                hint = stringResource(id = R.string.email)
            )

            Spacer(modifier = Modifier.height(spaceLarge))
            StandardTextField(text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsername(it)
                },
                hint = stringResource(id = R.string.username),
                error = viewModel.usernameError.value,

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
//                    navController.navigate(Screen.MainFeedScreen.route)
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
                    text = stringResource(id = R.string.sign_up),
                    style = MaterialTheme.typography.h3

                )
            }

        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account))
                append(" ")
                val signinText = stringResource(id = R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ){
                    append(signinText)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )
    }

}