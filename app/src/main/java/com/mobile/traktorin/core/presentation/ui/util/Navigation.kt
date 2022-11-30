import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.mobile.traktorin.core.presentation.MainFeedScreen
import com.mobile.traktorin.feature_profile.presentation.edit_profile.EditProfileScreen
import com.mobile.traktorin.feature_favorite.presentation.favorite.FavoriteScreen
import com.mobile.traktorin.feature_auth.presentation.login.LoginScreen
import com.mobile.traktorin.feature_chat.presentation.message.MessageScreen
import com.mobile.traktorin.feature_profile.presentation.profile.ProfileScreen
import com.mobile.traktorin.feature_auth.presentation.regis.RegisterScreen
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_auth.presentation.splash.SplashScreen
import com.mobile.traktorin.feature_service.presentation.create_servis.CreateServiceScreen



@ExperimentalCoilApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
){
    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
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
        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController, scaffoldState = scaffoldState )
        }

        composable(Screen.FavoriteScreen.route){
            FavoriteScreen(navController = navController)
        }
        composable(Screen.ServiceScreen.route){


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

        composable(Screen.CreateServiceScreen.route){
            CreateServiceScreen(navController = navController,scaffoldState = scaffoldState)
        }


        composable(Screen.DetailFeedScreen.route){

        }

    }
}