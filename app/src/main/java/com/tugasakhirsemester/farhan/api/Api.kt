package com.tugasakhirsemester.farhan.api

import com.tugasakhirsemester.farhan.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>
}