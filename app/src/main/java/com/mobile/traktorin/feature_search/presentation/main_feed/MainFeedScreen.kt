package com.mobile.traktorin.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.components.*
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedEvent
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedViewModel
import kotlinx.coroutines.launch

@Composable
fun MainFeedScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: MainFeedViewModel = hiltViewModel()
    
){
    val posts = viewModel.posts.collectAsLazyPagingItems()
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SearchBar(navController = navController)
        Box(modifier = Modifier.fillMaxSize()){
            if (state.isLoadingFirstTime){
                CircularProgressIndicator(modifier = Modifier.align(Center))
            }
            LazyColumn {
                items(posts){ post ->
                    Post(post = Post(
                        fullname = post?.fullname ?: "",
                        imageUrl = post?.imageUrl ?: "",
                        description = post?.description ?: "",
                        village = post?.village ?: "",
                        district = post?.district ?: "",
                        province = post?.province ?: "",
                        price = post?.price ?: "",
                        username = post?.username ?: ""
                    ),
                        onPostClick = {
//                navController = navController.navigate(Screen.DetailFeedScreen.route)
                        }
                    )
                }
                item{
                    if (state.isLoadingNewPosts){
                        CircularProgressIndicator(modifier = Modifier.align(BottomCenter))
                    }
                }

                posts.apply {
                    when{
                        loadState.refresh is LoadState.Loading -> {
                            viewModel.onEvent(MainFeedEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Loading ->{
                            viewModel.onEvent(MainFeedEvent.LoadingMorePosts)
                        }
                        loadState.append is LoadState.NotLoading ->{
                            viewModel.onEvent(MainFeedEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Error ->{
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Error"
                                )

                            }

                        }
                    }

                }
            }
        }



    }

}




@Composable
fun SearchBar(
    navController: NavController,

){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(spaceSmall))

    {
        StandardTextField(
            modifier = Modifier.shadow(5.dp),
            hint = "Pencarian",
//            error = viewModel.searchState.value.error,
//            text = viewModel.searchState.value.text,
            shape = RoundedCornerShape(30.dp),
        ) {
//            viewModel.setSearchState(
//                StandarTextFieldState(it)
//            )
        }
    }
}
