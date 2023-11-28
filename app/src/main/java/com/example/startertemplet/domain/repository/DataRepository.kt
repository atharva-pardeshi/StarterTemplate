package com.example.startertemplet.domain.repository

import com.example.startertemplet.domain.service.ApiService
import com.example.startertemplet.viewModel.response.DataResponse
import com.example.startertemplet.viewModel.response.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun fetchData(): Flow<Resource<DataResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val response = apiService.getTermsOfUse()
                emit(Resource.Success(data = response))
                emit(Resource.Loading(false))
            } catch (e: Exception) {
                emit(Resource.Error(message = e.message))
            }
        }
    }
}
