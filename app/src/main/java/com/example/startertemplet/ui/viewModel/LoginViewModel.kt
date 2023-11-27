package com.example.startertemplet.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startertemplet.ui.domain.repository.DataRepository
import com.example.startertemplet.ui.viewModel.response.DataResponse
import com.example.startertemplet.ui.viewModel.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {
    private val _data = MutableSharedFlow<DataResponse>()
    val data = _data.asSharedFlow()

    fun fetchData() {
        viewModelScope.launch {
            repository.fetchData().collect {
                when (it){
                    is Resource.Success -> {
                        it.data?.let { it1 -> _data.emit(value = it1) }
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }

                    else -> {}
                }
            }
        }
    }
}
