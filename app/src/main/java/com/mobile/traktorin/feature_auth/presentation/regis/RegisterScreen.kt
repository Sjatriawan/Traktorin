package com.mobile.traktorin.feature_auth.presentation.regis

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
import com.mobile.traktorin.core.presentation.ui.util.asString
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import kotlinx.coroutines.flow.collectLatest


@Composable
fun RegisterScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val usernameState = viewModel.usernameState.value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val registerState = viewModel.registerState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is UiEvent.SnackBarEvent ->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.uiText.asString(context),
                        duration = SnackbarDuration.Long
                    )
                }
                else -> {}
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
            Text(
                text = stringResource(id = R.string.intro2),
                style= MaterialTheme.typography.h1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = stringResource(id = R.string.intro_regis),
                style= MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(spaceSmall))
            Image(
                painterResource(id = R.drawable.join),
                contentDescription ="welcome",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.height(spaceSmall))
            Text(text = stringResource(id = R.string.email),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                error = when(emailState.error){
                      is AuthError.FieldEmpty ->{
                          stringResource(id = R.string.this_field_cant_be_empty)
                      }
                      is AuthError.InvalidEmail -> {
                            stringResource(id = R.string.this_is_not_valid_email)
                      }
                      else -> ""
                      },
                hint = stringResource(id = R.string.email_hint),
                shape = RoundedCornerShape(spaceSmall)
            )

            Spacer(modifier = Modifier.height(spaceSmall))
            Text(text = stringResource(id = R.string.username),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = usernameState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                hint = stringResource(id = R.string.ex_user),
                error = when(viewModel.usernameState.value.error){
                    is AuthError.InputTooShort->{
                        stringResource(id = R.string.usermae_too_short)
                    }
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.username_cant_be_empty)
                    }
                   else  -> ""
                },
                shape = RoundedCornerShape(spaceSmall)

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
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                hint = stringResource(id = R.string.enter_your_password),
                keyboardType = KeyboardType.Password,
                error = when(passwordState.error){
                    is AuthError.FieldEmpty ->{
                        stringResource(id = R.string.password_cant_be_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.Password_too_short)
                    }
                    is AuthError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    else -> ""
                },
                showPasswordToggle = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(RegisterEvent.TogglePasswordVisibility)
                },
                shape = RoundedCornerShape(spaceSmall)
            )
            Spacer(modifier = Modifier.height(spaceSmall))
            Text(
                style = MaterialTheme.typography.h3,
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.have_an_account))
                    append(" ")
                    val signinText = stringResource(id = R.string.sign_in)
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.primary,

                        )
                    ){
                        append(signinText)
                    }
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.height(spaceSmall))
            Button(
                onClick = {
                          viewModel.onEvent(RegisterEvent.Register)
                },
                enabled = !registerState.isLoading,
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
                    style = MaterialTheme.typography.h2

                )
            }
            if (registerState.isLoading){
                CircularProgressIndicator()
            }
        }

    }

}