package com.mobile.response

data class BasicApiResponse<T>(
    val successful:Boolean,
    val message:String? = null,
    val data: T? = null
    )