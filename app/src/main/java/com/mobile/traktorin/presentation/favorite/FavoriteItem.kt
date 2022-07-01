package com.mobile.traktorin.presentation.favorite

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobile.traktorin.R
import com.mobile.traktorin.domain.models.Favorite
import com.mobile.traktorin.presentation.ui.theme.Poppins
import com.mobile.traktorin.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.presentation.ui.theme.spaceSmall
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun FavoriteItem(
    modifier: Modifier = Modifier,
    favorite:Favorite
){
    Card(
        modifier.padding(top = spaceSmall),
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.White,
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(start = spaceSmall),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.postphoto),
                contentDescription = null,
                modifier.size(100.dp).padding(end = spaceMedium)
            )
            Text(
                text = favorite.username,
                color = Color.Black,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}