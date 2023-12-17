package com.exercise.tbchomeworkeighteen.data.network

import com.exercise.tbchomeworkeighteen.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(@Query("page")page: Int, @Query("per_page")perPage: Int): ApiResponse

}