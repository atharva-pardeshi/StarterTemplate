package com.example.startertemplet.viewModel.response

data class DataResponse(
    val id: Int,
    val name: String,
    val description: String
    // Add more properties as needed
)

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}