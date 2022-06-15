import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobile.traktorin.presentation.SearchScreen
import com.mobile.traktorin.presentation.favorite.FavoriteScreen
import com.mobile.traktorin.presentation.login.LoginScreen
import com.mobile.traktorin.presentation.message.MessageScreen
import com.mobile.traktorin.presentation.profile.ProfileScreen
import com.mobile.traktorin.presentation.regis.RegisterScreen
import com.mobile.traktorin.presentation.servis.ServisScreen
import com.mobile.traktorin.presentation.splash.SplashScreen
import com.mobile.traktorin.presentation.ui.util.Screen

@Composable
fun Navigation(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
            
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)

        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)

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

    }
}