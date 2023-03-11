package com.mobile.traktorin.feature_order.presentation.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.CreateRadioButton
import com.mobile.traktorin.core.presentation.components.ShowText
import com.mobile.traktorin.core.presentation.components.StandardTextField
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.spaceExtraLarge
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.util.UiText

@Composable
fun CreateOrderScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    scaffoldState: ScaffoldState,
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(text = "Order")
            }
        )

        Column(modifier = Modifier.fillMaxWidth().padding(start = spaceMedium, end = spaceMedium)
        ) {
            Spacer(modifier = Modifier.height(spaceSmall))
            ShowText(
                text = "Luas tanah",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxWidth()
            )
            StandardTextField(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
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
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(spaceMedium)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(spaceMedium)
            ) {
                val optionSelected:Boolean
                Icon(painterResource(id = R.drawable.icon_price), contentDescription = null)
                ShowText(
                    text = stringResource(id = R.string.cash) ,
                    style = MaterialTheme.typography.h3 ,
                    modifier = Modifier.padding(start = spaceMedium)
                )
            }
        }



    }
}



@Composable
@Preview(showBackground = true, backgroundColor = 0x0FFFFFF)
fun PreviewOrder(){
    CreateOrderScreen(scaffoldState = rememberScaffoldState())
}