package com.mobile.traktorin.feature_service.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.CreateButton
import com.mobile.traktorin.core.presentation.components.Post
import com.mobile.traktorin.core.presentation.components.ShowText
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.Poppins
import com.mobile.traktorin.feature_search.presentation.detail_service.DetailFeedViewModel


@Composable
fun DetailFeedScreen(
    onNavigate:(String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: DetailFeedViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberImagePainter(
                        data = state.post?.imageUrl,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = "Post image"
                )
                StandardToolbar(
                    onNavigateUp = onNavigateUp,
                    showOnlyBackArrow = true,
                    backgroundColor = Color.Transparent,
                )
            }
            //Row Name
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp)
            ) {
                Image(
                    painterResource(R.drawable.icon_verifieduser),
                    contentDescription = "uUser",
                    modifier = Modifier
                        .size(24.dp)
                        .align(alignment = CenterVertically)
                        .offset(x = -4.dp, y = -3.dp)
                )
                state.post?.let { post ->
                    ShowText(
                        text = post.fullname ,
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.Black,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                }
            }
            state.post?.let { post ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                    Icon(
                        imageVector = Icons.Default.MyLocation,
                        contentDescription = "Village",
                        tint = Color.Blue,
                        modifier = Modifier
                            .size(24.dp)
                            .align(alignment = CenterVertically)
                            .offset(x = -4.dp, y = 0.dp)
                    )
                    ShowText(
                        text = state.post.village,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                    )
                    ShowText(
                        text = ", ",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                    )
                    ShowText(
                        text = state.post.district,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                    )
                }

                ShowText(
                    text = state.post?.description ?: "",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    ),
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp, end = 10.dp)
                )
                ShowText(
                    text = "Status: Bersedia",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        Column(Modifier.align(BottomCenter)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ShowText(
                    text = "15.000",
                    style = TextStyle(
                        fontSize = 30.sp,
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
                onClick = {}
            )
        }

    }
}
