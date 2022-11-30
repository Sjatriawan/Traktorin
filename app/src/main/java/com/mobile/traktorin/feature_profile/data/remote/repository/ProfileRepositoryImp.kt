package com.mobile.traktorin.feature_profile.data.remote.repository

import com.mobile.traktorin.R
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_profile.data.remote.ProfileApi
import com.mobile.traktorin.feature_profile.domain.model.Profile
import com.mobile.traktorin.feature_profile.domain.repository.ProfileRepository
import okio.IOException
import retrofit2.HttpException

class ProfileRepositoryImp(
    private val api:ProfileApi
):ProfileRepository {
    override suspend fun getProfile(userId: String): Resource<Profile> {
        return try {
            val response = api.getProfile(userId)
            if (response.successful){
                Resource.Success(response.data?.toProfile())
            }else{
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))

            }
        } catch (e:IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
            )
        }
        catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_wrong)
            )
        }

    }
}
