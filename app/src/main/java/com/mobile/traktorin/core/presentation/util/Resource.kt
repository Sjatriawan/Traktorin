package com.mobile.traktorin.core.presentation.util


typealias SimpleResource<T> = Resource<Unit>
sealed class Resource<T> (val data:T? = null,val uiText:UiText? = null) {
    class Success<T>(data: T?):Resource<T>(data)
    class Error<T>(uiText:UiText, data: T? = null):Resource<T>(data , uiText)
}