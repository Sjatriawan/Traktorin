package com.mobile.traktorin.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobile.traktorin.core.domain.models.PostModel
import com.mobile.traktorin.core.presentation.components.*
import com.mobile.traktorin.feature_search.presentation.search.SearchViewModel
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.util.Screen

@Composable
fun SearchScreen(
    navController: NavController,
){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(spaceSmall)) {
            SearchBar(navController = navController)
            LazyColumn(modifier = Modifier.fillMaxSize()){
                item {
                    ItemPost(navController = navController)
                }
            }
        }
    }
}




@Composable
fun ItemPost(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(spaceSmall))
        repeat(10){
            Post(
                post = PostModel(
                    imageUrl = "",
                    locate = "Pogading, Lombok Timur",
                    distance = "2 kilometer",
                    price = "130 .000",
                ),
                onPostClick = {
                    navController.navigate(Screen.PostDetailScreen.route)
                }
            )
        }

    }
}

@Composable
fun SearchBar(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(spaceSmall))

    {
        StandardTextField(
            modifier = Modifier.shadow(5.dp),
            hint = "Pencarian",
            error = viewModel.searchState.value.error,
            text = viewModel.searchState.value.text,
            shape = RoundedCornerShape(30.dp),
        ) {
            viewModel.setSearchState(
                StandarTextFieldState(it)
            )
        }
    }
}

@Composable
fun SearchSetting(){

}