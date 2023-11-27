package com.example.startertemplet.ui.domain.service

import com.example.startertemplet.ui.viewModel.response.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("services/custom-software-development.html")
    suspend fun getTermsOfUse(): DataResponse
}
