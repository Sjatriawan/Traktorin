//package com.mobile.traktorin.feature_service.presentation.create_servis
//
//import android.net.Uri
//import com.mobile.traktorin.core.presentation.util.SimpleResource
//import com.mobile.traktorin.feature_service.domain.repository.ServiceRepository
//
//data class CreateServiceUseCase(
//    private val repository: ServiceRepository
//){
//    suspend operator fun invoke(
//        fullname:String,
//        village:String,
//        district: String,
//        province:String,
//        description: String,
//        price:Double,
//        imageUri:Uri
//    ):SimpleResource{
//        return repository.createPost(fullname, village, district, province, description, price, imageUri)
//    }
//}