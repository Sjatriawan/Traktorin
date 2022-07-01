package com.mobile.traktorin.domain.models

data class PostModel(
    var imageUrl:String,
    override var locate:String,
    var distance:String,
    var price:String
):Detail()

open class Detail (
    open var merk: String = "",
    open var name: String = "",
    open var locate: String = "",
    open var service_by:String = ""
)