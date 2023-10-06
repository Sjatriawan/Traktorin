package com.mobile.traktorin.feature_service.presentation.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.AddFavoriteButton
import com.mobile.traktorin.core.presentation.components.CreateButton
import com.mobile.traktorin.core.presentation.components.ShowText
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.Poppins
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_search.presentation.detail_service.DetailFeedViewModel
import java.text.NumberFormat
import java.util.*


@Composable
fun DetailFeedScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: DetailFeedViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Log.d("OrderDetailScreen", "Village: ${state.post?.price}")

    Box(modifier = Modifier.fillMaxSize()){
        Column(Modifier.fillMaxSize()) {
            Image(
                rememberImagePainter(
                    data = state.post?.imageUrl,
                    builder = {
                        crossfade(true)
                        error(R.drawable.postphoto)
                    }
                ),
                contentDescription = "Post Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )

            //Item
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp)

            )
            {
                Row(Modifier.fillMaxWidth()) {
                    state.post?.let {
                        Image( painterResource(R.drawable.icon_verifieduser),
                            contentDescription = "Price",
                            modifier = Modifier
                                .size(24.dp)
                                .align(alignment = CenterVertically)
                                .offset(x = -4.dp, y = -3.dp)
                        )
                        ShowText(
                            text = it.fullname, style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.Black,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold
                        ),
                            modifier = Modifier.padding(start = 10.dp, end = 4.dp))
                }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        AddFavoriteButton(
                            modifier = Modifier.padding(spaceSmall)
                        ){

                        }

                    }

                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)) {
                state.post?.let {
                    Icon(
                        imageVector = Icons.Default.MyLocation,
                        contentDescription = "Village",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(24.dp)
                            .align(alignment = CenterVertically)
                            .offset(x = -4.dp, y = -3.dp)
                    )
                    ShowText(
                        text = it.village, style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal
                    ),
                        modifier = Modifier.padding(start = 10.dp, end = 4.dp))

                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp)) {
                state.post?.let {
                    ShowText(text = it.description, style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Thin
                    ),
                        modifier = Modifier.padding(start = 10.dp, end = 4.dp))

                }
            }

        }

        StandardToolbar(
            showOnlyBackArrow = true,
            onNavigateUp = onNavigateUp,
            backgroundColor = Color.Transparent,

        )

        Column(modifier = Modifier.align(BottomCenter)){
            val numberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                ShowText(
                    text = state.post?.price.toString(),
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
                    modifier = Modifier.align(CenterVertically)
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



