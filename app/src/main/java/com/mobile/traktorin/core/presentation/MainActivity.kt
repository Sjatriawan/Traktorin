package com.mobile.traktorin.core.presentation

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobile.traktorin.core.presentation.components.StandardScaffold
import com.mobile.traktorin.core.presentation.ui.theme.TraktorinTheme
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_auth.presentation.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TraktorinTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val scaffoldState = rememberScaffoldState()
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    StandardScaffold(
                        navController = navController,
                        showBottomBar =  navBackStackEntry?.destination?.route in listOf(
                            Screen.SearchScreen.route,
                            Screen.FavoriteScreen.route,
                            Screen.ServiceScreen.route,
                            Screen.MessageScreen.route,
                            Screen.ProfileScreen.route
                            ),
                        showBackArrow = navBackStackEntry?.destination?.route in listOf(
                            Screen.PostDetailScreen.route
                    ),
                        state = scaffoldState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Navigation(navController, scaffoldState)
                    }

                }
            }
        }
    }
}

