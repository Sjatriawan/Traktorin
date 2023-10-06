package com.mobile.traktorin.core.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi

import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.theme.verySmall
import java.text.NumberFormat
import java.util.*


@ExperimentalCoilApi
@Composable
fun Post(
    modifier: Modifier = Modifier,
    post: Post,
    onPostClick:() -> Unit
){
    val numberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spaceMedium)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color.White)
                .clickable {
                    onPostClick()
                }
        ){
            Image(
                rememberImagePainter(
                    data = post.imageUrl,
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
            Spacer(modifier = Modifier.padding(verySmall))

            Row {
                Image( painterResource(R.drawable.icon_verifieduser),
                    contentDescription = "Price",
                    modifier = Modifier
                        .size(18.dp)
                        .align(alignment = Bottom)
                )
                Spacer(modifier = Modifier.padding(verySmall))
                Text(
                    text = post.fullname,
                    style = MaterialTheme.typography.h6,
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = "Village",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(18.dp)
                        .align(alignment = Bottom)
                )
                Spacer(modifier = Modifier.padding(verySmall))
                Text(
                    text = post.village,
                    style = MaterialTheme.typography.h6
                )

            }
            Row {
                Image( painterResource(R.drawable.icon_price),
                    contentDescription = "Price",
                    modifier = Modifier
                        .size(18.dp)
                        .align(alignment = Bottom)
                )
                Spacer(modifier = Modifier.padding(verySmall))
                Text(
                    text =  numberFormat.format(post.price).replace("IDR ", "Rp ").replace(",00", ""),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(CenterVertically)
                )
            }

        }


    }
}


