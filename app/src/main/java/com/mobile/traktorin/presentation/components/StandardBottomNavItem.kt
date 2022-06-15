package com.mobile.traktorin.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    icon: ImageVector,
    label: String? = null,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = Color.Gray,
    enabled: Boolean = true,
    onClick: () -> Unit
){
  BottomNavigationItem(
      selected = selected,
      onClick = onClick,
      modifier = modifier,
      enabled = enabled,
      label = {
          if (label != null) {
              Text(label)
          }
      },
      selectedContentColor = selectedColor,
      unselectedContentColor = unselectedColor,
      icon = {
          Box(
              modifier = Modifier.fillMaxSize()
          ){
              Icon(
                  imageVector = icon ,
                  contentDescription = contentDescription,
                  modifier = Modifier
                      .align(Alignment.Center)
                      .padding(top = 25.dp),
              )

          }
      }

  )
  }
