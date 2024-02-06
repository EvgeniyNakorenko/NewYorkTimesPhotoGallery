package com.example.alpha.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpha.domain.GetContentUseCase
import com.example.alpha.entity.ResultsInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getContentUseCase: GetContentUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<ResultsInterface?>(null)
    val state = _state.asStateFlow()

    fun reloadPhotos() {
        var content: ResultsInterface?
        viewModelScope.launch(Dispatchers.IO) {
            content = getContentUseCase.execute()
            _state.value = content
        }
    }

}
