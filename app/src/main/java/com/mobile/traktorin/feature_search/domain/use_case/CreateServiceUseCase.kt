package com.mobile.traktorin.feature_search.domain.use_case

import android.net.Uri
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_search.domain.repository.PostRepository

data class CreateServiceUseCase (
        private val repository: PostRepository
        ){
        suspend operator fun invoke(
                fullname: String,
                village: String,
                district: String,
                province: String,
                description: String,
                price: Double,
                imgFile: Uri?
        ):SimpleResource<Any?> {
                if (imgFile == null){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_image)
                        )
                }
                if (fullname.isBlank()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_fullname)
                        )
                }

                if (village.isBlank()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_village)
                        )
                }
                if (district.isBlank()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_district)
                        )
                }
                if (province.isBlank()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_province)
                        )
                }
                if (price.isNaN()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_price)
                        )
                }

                if (description.isBlank()){
                        return Resource.Error(
                                uiText = UiText.StringResource(R.string.error_description)
                        )
                }

                return repository.createPost(
                        fullname,
                        village,
                        district,
                        province,
                        description,
                        price,
                        imgFile
                )
        }
}

