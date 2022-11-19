import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.traktorin.core.domain.models.Detail
import com.mobile.traktorin.core.presentation.SearchScreen
import com.mobile.traktorin.feature_service.presentation.detail.PostDetail
import com.mobile.traktorin.feature_profile.presentation.edit_profile.EditProfileScreen
import com.mobile.traktorin.feature_favorite.presentation.favorite.FavoriteScreen
import com.mobile.traktorin.feature_auth.presentation.login.LoginScreen
import com.mobile.traktorin.feature_chat.presentation.message.MessageScreen
import com.mobile.traktorin.feature_profile.presentation.profile.ProfileScreen
import com.mobile.traktorin.feature_auth.presentation.regis.RegisterScreen
import com.mobile.traktorin.feature_service.presentation.servis.ServisScreen
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_auth.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
){
    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(
                navController = navController,
                scaffoldState = scaffoldState)

        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )

        }
        composable(Screen.SearchScreen.route){
            SearchScreen(navController = navController)
        }

        composable(Screen.FavoriteScreen.route){
            FavoriteScreen(navController = navController)
        }
        composable(Screen.ServiceScreen.route){
            ServisScreen(navController = navController)

        }
        composable(Screen.MessageScreen.route){
            MessageScreen(navController = navController)
        }

        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }

        composable(Screen.EditProfileScreen.route){
            EditProfileScreen(navController = navController)
        }

        composable(Screen.PostDetailScreen.route){
            PostDetail(
                navController = navController,
                post = Detail(
                    merk = "Traktor G12KX",
                    name = "Amak Mashan",
                    locate = "Ambatukam",
                    service_by = "Dilayani oleh:",
                ),
            )
        }

    }
}