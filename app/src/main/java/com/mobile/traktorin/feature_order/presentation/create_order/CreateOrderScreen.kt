package com.mobile.traktorin.feature_order.presentation.create_order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.*
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.util.Screen

@Composable
fun CreateOrderScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    scaffoldState: ScaffoldState,
){

    Box(modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            StandardToolbar(
                onNavigateUp = onNavigateUp,
                showBackArrow = true,
                title = {
                    Text(text = stringResource(id = R.string.confirm_now))
                }
            )

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = spaceMedium, end = spaceMedium)
            ) {
                Spacer(modifier = Modifier.height(spaceSmall))
                ShowText(
                    text = stringResource(id = R.string.luas_tanah),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                StandardTextField(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(spaceSmall),
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                    },
                )

                Spacer(modifier = Modifier.height(spaceSmall))
                ShowText(
                    text = "Lokasi sawah",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.fillMaxWidth()
                )

                StandardTextField(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {

                    } )

                Spacer(modifier = Modifier.height(spaceSmall))
                ShowText(
                    text = "Catatan",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.fillMaxWidth()
                )

                StandardTextField(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {

                    } )

                ShowText(
                    text = stringResource(id = R.string.payment_method),
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                )
                Column(
                    Modifier
                        .fillMaxWidth().padding(top = 10.dp)
                ) {
                    CreateRadioButton()
                }
            }

        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CreateButton(
                    text = stringResource(id = R.string.confirm_now
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    onClick = {
                        onNavigate(Screen.OrderScreenSuccess.route)
                    }
                )
            }

        }
    }
}


