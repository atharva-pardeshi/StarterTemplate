package com.example.startertemplet.viewModel.response

sealed class Resource<T>(
    val data: T? = null,
    val dataList: List<T?> = mutableListOf(),
    val message: String? = null,
    val errorCode: Int? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)

    class SuccessList<T>(dataList: List<T?>) : Resource<T>(dataList = dataList)

    class Error<T>(message: String?, data: T? = null, errorCode: Int? = null) :
        Resource<T>(data, mutableListOf(), message, errorCode)

    class Loading<T>(val isLoading: Boolean = true) : Resource<T>(null)
}