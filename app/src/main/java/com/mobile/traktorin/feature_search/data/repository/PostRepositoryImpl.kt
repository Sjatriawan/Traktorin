package com.mobile.traktorin.feature_search.data.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.google.gson.Gson
import com.mobile.traktorin.feature_service.data.dto.request.CreatePostRequest
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.Util.getFileName
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_search.data.data_source.paging.PostSource
import com.mobile.traktorin.feature_search.domain.repository.PostRepository
import com.mobile.traktorin.feature_search.data.data_source.remote.PostApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okio.IOException
import retrofit2.HttpException
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class PostRepositoryImpl(
    private val api: PostApi,
    private val gson: Gson,
    private val appContext: Context
):PostRepository {
    override val posts: Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constant.PAGE_SIZE_POSTS)){
            PostSource(api)
        }.flow

    override suspend fun createPost(
        fullname:String,
        village:String,
        district: String,
        province:String,
        description: String,
        price:String,
        imgFile: Uri
    ): SimpleResource {
        val request = CreatePostRequest(fullname,village,district,province,description,price)
        val file = withContext(Dispatchers.IO){
            appContext.contentResolver.openFileDescriptor(imgFile,"r")?.let { fd ->
                val inputStream = FileInputStream(fd.fileDescriptor)
                val file = File(
                    appContext.cacheDir,
                    appContext.contentResolver.getFileName(imgFile)
                )
                val outputStream = FileOutputStream(file)
                inputStream.copyTo(outputStream)
                file
            }
        }?: return Resource.Error(
            uiText = UiText.StringResource(R.string.error_file_not_found)
        )
//        Log.d("Gambar", file.toString())
//        Log.d("Data", request.toString())
        return try {
            val response = api.createPost(
                postData = MultipartBody.Part
                    .createFormData(
                        name = "post_data",
                        gson.toJson(request),
                    )
                ,
                postImage = MultipartBody.Part
                    .createFormData(
                        name = "post_image",
                        filename = file.name,
                        body = file.asRequestBody()
                    )
            )
            Log.d("Data", request.toString())
            if (response.successful){
                Resource.Success(Unit)
            }else{
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))

                } ?:
                Resource.Error(UiText.StringResource(R.string.error_unknown))
            }

        }catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_wrong)
            )
        }catch (e:IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
            )
        }

    }
}