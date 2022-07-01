package com.mobile.traktorin.presentation.components


import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobile.traktorin.R
import com.mobile.traktorin.domain.models.BottomNavItem
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    showBottomBar:Boolean = true,
    showToolBar:Boolean = true,
    toolbarTitle:String?= null,
    showBackArrow:Boolean = true,
    navActions:@Composable RowScope.() -> Unit ={},
    viewModel: StandardScaffoldViewModel = hiltViewModel(),
    bottomNavItems: List<BottomNavItem> =listOf(
        BottomNavItem(
            route = Screen.SearchScreen.route,
            icon = Icons.Outlined.Search,
            contentDescription = "Search",
            label = "Telusuri"
        ),
        BottomNavItem(
            route = Screen.FavoriteScreen.route,
            icon = Icons.Outlined.Favorite,
            contentDescription = "Favorite",
            label = "Favorit"
        ),
        BottomNavItem(
            route = Screen.ServiceScreen.route,
            icon = Icons.Outlined.Workspaces,
            contentDescription = "Service",
            label = "Jasa"
        ),
        BottomNavItem(
            route = Screen.MessageScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message",
            label = "Pesan"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile",
            label = "Profil"
        ),

    ),
    content: @Composable () -> Unit
){
    
    Scaffold(
        bottomBar = {
            if (showBottomBar){
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.White,
                    elevation = 10.dp
                ) {
                    BottomNavigation(
                        modifier = Modifier.fillMaxWidth(),
                        backgroundColor = Color.White,
                    ) {
                        bottomNavItems.forEachIndexed{ i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selectedColor = MaterialTheme.colors.primary,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                label = bottomNavItem.label
                            ) {
                                if(navController.currentDestination?.route != bottomNavItem.route){
                                    navController.navigate(bottomNavItem.route)
                                }

                            }
                        }

                    }
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}