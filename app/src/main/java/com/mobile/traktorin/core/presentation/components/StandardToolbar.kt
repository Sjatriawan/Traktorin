package com.mobile.traktorin.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.traktorin.R
@Composable
fun StandardToolbar(
    onNavigateUp: () -> Unit = {},
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    showOnlyBackArrow: Boolean = false,
    isBlack: Boolean = true,
    hint: @Composable () -> Unit = {},
    navAction: @Composable() (RowScope.() -> Unit) = {},
    title: @Composable () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primary
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon =
        if(showBackArrow) {
            {
                IconButton(onClick = {
                    onNavigateUp()

                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.Black,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }else if(showOnlyBackArrow) {
            {
                IconButton(onClick = {
                    onNavigateUp()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }else null,


        actions = navAction,
        backgroundColor = backgroundColor,
        elevation = 5.dp

    )
}
