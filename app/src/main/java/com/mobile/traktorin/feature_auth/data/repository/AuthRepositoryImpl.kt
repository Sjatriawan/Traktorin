package com.mobile.traktorin.feature_auth.data.repository

import com.mobile.data.request.CreateAccountRequest
import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_auth.data.remote.AuthAPI
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository
import com.mobile.traktorin.feature_auth.presentation.regis.RegisterEvent
import okio.IOException
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val api:AuthAPI
):AuthRepository{

    override suspend fun register(
        email:String,
        username: String,
        password:String
    ): SimpleResource {
        val request = CreateAccountRequest(email,username, password)
       return try {
            val response = api.register(request)
            if (response.successful){
                Resource.Success(Unit)
            }else{
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))

            }
       }
       catch (e:HttpException){
           Resource.Error(
               uiText = UiText.StringResource(R.string.something_wrong)
           )
       }
       catch (e:IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
              )
       }
    }
}