package com.mobile.traktorin.feature_order.presentation.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.verySmall
import com.mobile.traktorin.R



@ExperimentalCoilApi
@Composable
fun OrderItem(
    modifier: Modifier = Modifier,
    order: Booking,
    onOrderClick:() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spaceMedium)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color.White)
                .clickable {
                    onOrderClick()
                }
           ) {
            Image(
               rememberImagePainter(
                   data = order.imageUrl,
                   builder = {
                       crossfade(false)
                       error(R.drawable.postphoto)
                   }
               ),
                contentDescription = "Order Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
            Spacer(modifier = Modifier.padding(verySmall))
            Row {
                Spacer(modifier = Modifier.padding(verySmall))
                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = order.address,
                        style = MaterialTheme.typography.h3
                    )
                    Text(
                        text = order.are.toString(),
                        style = MaterialTheme.typography.h3
                    )
                    Text(
                        text = order.employee,
                        style = MaterialTheme.typography.h3
                    )
                }


            }
        }
    }
}