package com.mobile.traktorin.feature_service.presentation.create_servis


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.components.StandardTextField
import com.mobile.traktorin.core.presentation.components.StandardToolbar
import com.mobile.traktorin.core.presentation.ui.theme.spaceExtraLarge
import com.mobile.traktorin.core.presentation.ui.theme.spaceLarge
import com.mobile.traktorin.core.presentation.ui.theme.spaceMedium
import com.mobile.traktorin.core.presentation.ui.theme.spaceSmall
import com.mobile.traktorin.core.presentation.ui.util.asString
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import com.mobile.traktorin.feature_auth.domain.model.PostError
import com.mobile.traktorin.feature_profile.presentation.profile.components.SubMenu
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@Composable
fun CreateServiceScreen(
    navController: NavController,
    viewModel: CreateServiceViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState
) {

    val imageUri = viewModel.chosenImageUri.value
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        viewModel.onEvent(CreateServiceEvent.PickImage(it))
    }



    val context = LocalContext.current
    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is UiEvent.ShowSnackBar ->{
                    GlobalScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = event.uiText.asString(context)
                        )
                    }

                }
                is UiEvent.NavigateUp ->{
                    navController.navigateUp()
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            showBackArrow = true,
            title = {
                Text(text = stringResource(id = R.string.create_post))
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spaceLarge)
                .verticalScroll(rememberScrollState())
        ){
            SubMenu(stringResource(id = R.string.ready_for))
            Text(text = stringResource(id = R.string.intro_be_service),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(spaceExtraLarge))


            Text(text = stringResource(id = R.string.fullname),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.fullNameState.value.text,
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                  viewModel.onEvent(CreateServiceEvent.EnteredFullName(it))
                },
                error = when(viewModel.fullNameState.value.error){
                    is PostError.FieldEmpty ->
                        stringResource(id = R.string.fullnamae_cant_be_empty)
                    else -> ""
                },
            )


//            Text(text = stringResource(id = R.string.merk_tractor),
//                style= MaterialTheme.typography.h3,
//                textAlign = TextAlign.Start,
//                modifier = Modifier.align(Alignment.Start)
//            )
//            StandardTextField(
//                text = merkState.text,
//                modifier = Modifier.padding(10.dp),
//                shape = RoundedCornerShape(spaceSmall),
//                onValueChange = {
//                    viewModel.onEvent(CreateServiceEvent.EnteredMerk(it))
//                },
//                error = when(merkState.error){
//                    is AuthError.FieldEmpty ->{
//                        stringResource(id = R.string.merk_cant_be_empty)
//                    }
//                    else -> ""
//                },
//            )

            Text(text = stringResource(id = R.string.village),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.villageState.value.text,
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                    viewModel.onEvent(CreateServiceEvent.EnteredVillage(it))
                },
                error = when(viewModel.villageState.value.error){
                    is PostError.FieldEmpty ->{
                        stringResource(id = R.string.village_cant_be_empty)
                    }
                    else -> ""
                },
            )
            Text(text = stringResource(id = R.string.district),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.districtState.value.text,
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                    viewModel.onEvent(CreateServiceEvent.EnteredDistrict(it))
                },
                error = when(viewModel.districtState.value.error){
                    is PostError.FieldEmpty ->{
                        stringResource(id = R.string.district_cant_be_empty)
                    }
                    else -> ""
                },
            )


            Text(text = stringResource(id = R.string.province),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.provinceState.value.text,
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                    viewModel.onEvent(CreateServiceEvent.EnteredProvince(it))
                },
                error = when(viewModel.provinceState.value.error){
                    is PostError.FieldEmpty ->{
                        stringResource(id = R.string.province_cant_be_empty)
                    }
                    else -> ""
                },
            )

            Text(text = stringResource(id = R.string.price),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.priceState.value.text,
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(spaceSmall),
                keyboardType = KeyboardType.Number,
                onValueChange = {
                    viewModel.onEvent(CreateServiceEvent.EnteredPrice(it))
                },
                error = when(viewModel.priceState.value.error){
                    is PostError.FieldEmpty ->{
                        stringResource(id = R.string.price_cant_be_empty)
                    }
                    else -> ""
                },
            )

            Text(text = stringResource(id = R.string.description),
                style= MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            StandardTextField(
                text = viewModel.descriptionState.value.text,
                shape = RoundedCornerShape(spaceSmall),
                onValueChange = {
                    viewModel.onEvent(CreateServiceEvent.EnteredDescription(it))
                },
                error = when(viewModel.descriptionState.value.error){
                    is AuthError.FieldEmpty ->{
                        stringResource(id = R.string.description_cant_be_empty)
                    }
                    else -> ""
                },
            )

            Spacer(modifier = Modifier.height(spaceLarge))

            Box(
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable {
                        galleryLauncher.launch("image/*")
                    },
                contentAlignment = Alignment.Center
            ){
                    Icon(
                        imageVector = Icons.Default.Upload,
                        contentDescription ="upload_image",
                    )
                imageUri?.let { uri ->
                    Image(
                        painter = rememberImagePainter(
                            request = ImageRequest.Builder(LocalContext.current)
                                .data(uri)
                                .build()
                        ),
                        contentDescription = stringResource(id = R.string.post_image),
                        modifier = Modifier.matchParentSize()
                    )
                }

            }

            Spacer(modifier = Modifier.height(spaceLarge))
            Button(
                onClick = {
                          viewModel.onEvent(CreateServiceEvent.PostImage)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation =  ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp,
                ),
                enabled = !viewModel.isLoading.value
            ){
                Text(
                    text = stringResource(id = R.string.next),
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.width(spaceMedium))
                if (viewModel.isLoading.value){
                    CircularProgressIndicator(
                        color = MaterialTheme.colors.primary
                    )
                }else{
                    Icon(imageVector = Icons.Default.Send, contentDescription = null)
                }
            }
        }

    }
}