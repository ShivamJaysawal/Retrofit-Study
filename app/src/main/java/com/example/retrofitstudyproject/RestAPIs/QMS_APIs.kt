package com.example.retrofitstudyproject.RestAPIs

import com.example.retrofitstudyproject.model.AuthData
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface QMS_APIs {

    @FormUrlEncoded
    @POST("/oauth2/token")
    suspend fun getToken(@Header("Authorization") credentials: String,
                         @Field("grant_type") grant_type:String): Response<AuthData>
}

