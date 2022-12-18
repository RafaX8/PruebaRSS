package com.rafaelmardom.pruebarss.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.pruebarss.management.domain.DeleteRssUseCase
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase
import com.rafaelmardom.pruebarss.management.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel (
    private val getRssSourceUseCase: GetRssSourceUseCase,
    val deleteRssUseCase: DeleteRssUseCase
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
                    rssManagement
                ),
            )
        }
    }

    fun deleteRss(url:String){
        viewModelScope.launch (Dispatchers.IO){
            deleteRssUseCase.execute(url)
        }
    }

    data class ManagementUiState(
        val rssManagement: List<GetRssSourceUseCase.RssManagement> = emptyList()
    )

}