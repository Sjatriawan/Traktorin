package com.mobile.traktorin.core.presentation.ui.util

sealed class Screen (val route: String){
    object SplashScreen : Screen(route = "splash_screen")
    object LoginScreen : Screen(route = "login_screen")
    object RegisterScreen:Screen(route = "register_screen")
    object SearchScreen:Screen(route = "search_screen")
    object FavoriteScreen:Screen(route = "favorite_screen")
    object ServiceScreen:Screen(route = "service_screen")
    object MessageScreen:Screen(route = "message_screen")
    object ProfileScreen:Screen(route = "profile_screen")
    object PostDetailScreen:Screen(route = "post_detail_screen")
    object EditProfileScreen:Screen(route = "edit_profile_screen")
}