package com.rafaelmardom.pruebarss.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase
import com.rafaelmardom.pruebarss.management.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel (
    private val getRssSourceUseCase: GetRssSourceUseCase
) : ViewModel() {

    val managementPublisher: MutableLiveData<ManagementUiState> by lazy {
        MutableLiveData<ManagementUiState>()
    }

    fun loadRss(){
        managementPublisher.value = ManagementUiState()

        viewModelScope.launch(Dispatchers.IO) {
            val rssManagement = getRssSourceUseCase.execute()
            managementPublisher.postValue(
                ManagementUiState(
                    rssManagement,
                     // false
                ),
            )
        }
    }

    data class ManagementUiState(
        val rssManagement: List<GetRssSourceUseCase.RssManagement> = emptyList(),
        // val isLoading: Boolean = false
    )

}