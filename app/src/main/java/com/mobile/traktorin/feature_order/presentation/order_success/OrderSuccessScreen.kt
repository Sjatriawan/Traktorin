package com.mobile.traktorin.feature_order.presentation.order_success

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.CreateButton
import com.mobile.traktorin.core.presentation.components.ShowText
import com.mobile.traktorin.core.presentation.ui.util.Screen

@Composable
fun OrderSuccessScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
){
    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        Column(Modifier.align(Alignment.Center)) {
            ShowText(text = "Order success", style = MaterialTheme.typography.h1, modifier = Modifier)


        }
        Column(Modifier.align(Alignment.BottomCenter)) {
            CreateButton(
                text = stringResource(id = R.string.home
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
@Composable
@Preview(name = "Light Mode", showBackground = true)
fun PreviewOrder(){
    OrderSuccessScreen()
}