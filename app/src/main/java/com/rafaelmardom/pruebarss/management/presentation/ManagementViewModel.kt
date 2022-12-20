package com.rafaelmardom.pruebarss.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.pruebarss.management.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ManagementViewModel (
    private val saveRssUseCase: SaveRssUseCase
) : ViewModel() {

    val managementPublisher: MutableLiveData<ManagementUiState> by lazy {
        MutableLiveData<ManagementUiState>()
    }

    fun saveRss(website:String, url:String){
        viewModelScope.launch {
            saveRssUseCase.execute(website, url)
        }
        /*
        managementPublisher.value = ManagementUiState(true)

        viewModelScope.launch(Dispatchers.IO){
            saveRssUseCase.execute(website, url)
            managementPublisher.postValue(
                ManagementUiState(
                    true
                )
            )
        }
         */
    }

    data class ManagementUiState(
        val isSuccess: Boolean = false
    )

}