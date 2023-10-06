package com.mobile.traktorin.feature_order.presentation.order

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedEvent
import kotlinx.coroutines.launch
import kotlin.math.log


@Composable
fun OrderScreen(
    onNavigate:(String) -> Unit = {},
    viewModel: OrderViewModel =  hiltViewModel(),
    scaffoldState: ScaffoldState,

) {
    val state = viewModel.state.value
    val orders = viewModel.orders.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxSize()){
            if (state.isLoadingFirstTime){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            LazyColumn{
                items(orders){ order ->
                    if (order != null){
                        OrderItem(
                            order = Booking(
                                id = order.id,
                                address = order.address ?: "",
                                are = order?.are,
                                imageUrl = order?.imageUrl ?: "",
                                employee = order.employee ?: ""
                                ),
                            onOrderClick = {
                                onNavigate(Screen.OrderDetailScreen.route + "/${order?.id}")

                                Log.d(TAG, "Result: " + "/${order?.id}" );

                            }
                        )

                    }
                }

                item{
                    if (state.isLoadingNewOrder){
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
                    }
                }


                orders.apply {
                    when{
                        loadState.refresh is LoadState.Loading -> {
                            viewModel.onEvent(OrderEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Loading ->{
                            viewModel.onEvent(OrderEvent.LoadingMoreOrder)
                        }
                        loadState.append is LoadState.NotLoading ->{
                            viewModel.onEvent(OrderEvent.LoadedPage)
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


