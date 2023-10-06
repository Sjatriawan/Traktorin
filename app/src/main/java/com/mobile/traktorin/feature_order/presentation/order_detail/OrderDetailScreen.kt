package com.mobile.traktorin.feature_order.presentation.order

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.CreateButton
import com.mobile.traktorin.core.presentation.components.ShowText
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.Poppins
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_order.presentation.order_detail.OrderDetailViewModel
import java.text.NumberFormat
import java.util.*


@Composable
fun OrderDetailScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: OrderDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Image(
                rememberImagePainter(
                    data = state.order?.imageUrl,
                    builder = {
                        crossfade(true)
                        error(R.drawable.postphoto)
                    }
                ),
                contentDescription = "Order Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp)

            ){
                Column(Modifier.fillMaxWidth()) {
                    state.order?.let {
                        ShowText(
                            text = it.employee,
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = Color.Black,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(start = 10.dp, end = 4.dp)
                        )
                        ShowText(
                            text = it.address,
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = Color.Black,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(start = 10.dp, end = 4.dp)
                        )
                    }
                }

            }
        }

        StandardToolbar(
            showOnlyBackArrow = true,
            onNavigateUp = onNavigateUp,
            backgroundColor = Color.Transparent,

            )

        Column(modifier = Modifier.align(Alignment.BottomCenter)){
            val numberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                ShowText(
                    text = state.order?.are.toString(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(start = 10.dp, end = 4.dp)
                )
                ShowText(
                    text = "per are",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            CreateButton(
                text = "Order now",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                    onNavigate(Screen.CreateOrderScreen.route)
                }
            )
        }
    }
}

