package com.mobile.traktorin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.mobile.traktorin.R
import com.mobile.traktorin.presentation.ui.theme.DarkBlue
import com.mobile.traktorin.presentation.ui.theme.Yellow
import java.lang.Error

@Composable
fun StandardTextField(
    text:String = "",
    hint: String = "",
    error: String = "Error",
    isError: Boolean = false,
    maxLength:Int = 40,
    keyboardType: KeyboardType = KeyboardType.Text,
    showPasswordToggle:Boolean = false,
    onPasswordToggleClick:(Boolean) -> Unit = {},
    onValueChange:(String) -> Unit
){
    val isPasswordToggleDisplayed by remember{
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    Column(modifier = Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength){
                    onValueChange(it)
                }
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = DarkBlue,
                unfocusedBorderColor = Gray
            ),

            placeholder = {
                Text(text = hint,
                    style = MaterialTheme.typography.h4,

                )
            },


            isError = isError,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if(!showPasswordToggle && isPasswordToggleDisplayed){
                PasswordVisualTransformation()
            }else{
                VisualTransformation.None
            },
            singleLine = true,
            trailingIcon={
                if (isPasswordToggleDisplayed){
                    IconButton(onClick = {
                        onPasswordToggleClick(!showPasswordToggle)
                    }) {
                        Icon(
                            imageVector = if (showPasswordToggle){
                                Icons.Filled.VisibilityOff
                            }else{
                                Icons.Filled.Visibility
                            },
                            tint = Gray,
                            contentDescription = if(showPasswordToggle){
                                stringResource(id = R.string.password_visible_content_description)
                            }else{
                                stringResource(id = R.string.show_password)
                            }
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = "standard_text_field"
                }
        )
        if(error.isNotEmpty()) {
            Text(text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }

}