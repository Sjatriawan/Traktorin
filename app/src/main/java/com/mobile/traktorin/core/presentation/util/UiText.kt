package com.mobile.traktorin.core.presentation.util

import android.content.Context
import androidx.annotation.StringRes
import com.mobile.traktorin.R

sealed class UiText{
    data class DynamicString(val value:String):UiText()
    data class StringResource(@StringRes val id:Int):UiText()

    companion object{
        fun unknownError():UiText{
            return UiText.StringResource(R.string.error_unknown)
        }
    }
}
