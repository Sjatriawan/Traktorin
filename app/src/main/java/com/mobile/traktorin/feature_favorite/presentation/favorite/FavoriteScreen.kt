package com.mobile.traktorin.feature_favorite.presentation.favorite

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.components.FavoriteItem
import com.mobile.traktorin.core.presentation.components.Post
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedEvent
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun FavoriteScreen(
    onNavigate:(String) -> Unit = {},
    scaffoldState: ScaffoldState,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val favorites = viewModel.favorites.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()


    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoadingFirstTime) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            LazyColumn {
                items(favorites) {favorite ->
                        if (favorite != null) {
                            FavoriteItem(
                        favorite = Favorite(
                            price = favorite?.price,
                            fullname = favorite?.fullname,
                            village = favorite?.village
                        ),
                            onPostClick = {
                                    onNavigate(Screen.DetailFeedScreen.route + "/${favorite.postId}")
                                Log.d(favorite.postId, "FavoriteScreen: ")

                            }
                        )
                    }
                }

                favorites.apply {
                    when{
                        loadState.refresh is LoadState.Loading -> {
                            viewModel.onEvent(FavoriteEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Loading ->{
                            viewModel.onEvent(FavoriteEvent.LoadingMoreFavorite)
                        }
                        loadState.append is LoadState.NotLoading ->{
                            viewModel.onEvent(FavoriteEvent.LoadedPage)
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



