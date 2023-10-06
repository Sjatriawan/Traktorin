package com.mobile.traktorin.feature_auth.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.StandardTextField
import com.mobile.traktorin.core.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.core.presentation.ui.util.asString
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import kotlinx.coroutines.flow.collectLatest


@Composable
fun LoginScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: LoginViewModel = hiltViewModel()
){
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val state = viewModel.loginState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is UiEvent.ShowSnackBar ->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.uiText.asString(context)
                    )
                }
                is UiEvent.Navigate ->{
                    navController.navigate(Screen.MainFeedScreen.route)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = spaceLarge,
                end = spaceLarge,
                bottom = spaceMedium
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
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = stringResource(id = R.string.intro1),
                style= MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(spaceMedium))
            Image(
                painterResource(id = R.drawable.rafiki),
                contentDescription ="welcome",
                modifier = Modifier.fillMaxWidth().size(100.dp)
            )
            Spacer(modifier = Modifier.height(spaceMedium))
            Text(text = stringResource(id = R.string.email),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = emailState.text,
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredEmail(it))
                },
                error = when(emailState.error){
                    is AuthError.FieldEmpty ->{
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    is AuthError.InvalidEmail -> {
                        stringResource(id = R.string.this_is_not_valid_email)
                    }
                    else -> ""
                }
            )

            Spacer(modifier = Modifier.height(spaceSmall))
            Text(text = stringResource(id = R.string.password),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it)
                    )
                },
                keyboardType = KeyboardType.Password,
                showPasswordToggle = state.isPasswordVisible,
                error = when(passwordState.error){
                    is AuthError.FieldEmpty ->{
                        stringResource(id = R.string.password_cant_be_empty)
                    }
                    else -> ""
                },
                shape = RoundedCornerShape(spaceSmall),
                onPasswordToggleClick = {
                    viewModel.onEvent(LoginEvent.TogglePasswordVisibility)
                },
            )
            Spacer(modifier = Modifier.height(spaceSmall))
            Text(text = stringResource(id = R.string.forget_password),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.End,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(spaceLarge))
            Button(
                onClick = {
                    viewModel.onEvent(LoginEvent.Login)
                },
                enabled = !state.isLoading,
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
                    style = MaterialTheme.typography.h2

                )
            }

        }
        Text(
            style = MaterialTheme.typography.h3,
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