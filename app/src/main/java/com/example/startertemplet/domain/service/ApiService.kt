package com.example.startertemplet.domain.service

import com.example.startertemplet.viewModel.response.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("services/custom-software-development.html")
    suspend fun getTermsOfUse(): DataResponse
}
