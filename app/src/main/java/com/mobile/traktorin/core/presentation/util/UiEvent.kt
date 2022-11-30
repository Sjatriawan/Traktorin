package com.mobile.traktorin.core.presentation.util

sealed class UiEvent{
    data class ShowSnackBar(val uiText: UiText): UiEvent()
    data class Navigate( val route: String): UiEvent()
    object NavigateUp: UiEvent()
}