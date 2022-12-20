package com.rafaelmardom.pruebarss.management.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelmardom.pruebarss.management.domain.DeleteRssUseCase
import com.rafaelmardom.pruebarss.management.domain.DomainRss
import com.rafaelmardom.pruebarss.management.domain.GetRssSourceUseCase
import com.rafaelmardom.pruebarss.management.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel (
    private val getRssSourceUseCase: GetRssSourceUseCase,
    private val deleteRssUseCase: DeleteRssUseCase
) : ViewModel() {


    private val _managementPublisher = MutableLiveData(ManagementUiState())
    val managementPublisher: LiveData<ManagementUiState> = _managementPublisher

    /*
    val managementPublisher: MutableLiveData<ManagementUiState> by lazy {
        MutableLiveData<ManagementUiState>()
    }
     */

    fun loadRss(){
        viewModelScope.launch {
            getRssSourceUseCase.execute()
                .collect { domainRss ->
                    _managementPublisher.postValue(
                        ManagementUiState(
                            domainRss
                        )
                    )
                }
        }
        /*
        managementPublisher.value = ManagementUiState()

        viewModelScope.launch(Dispatchers.IO) {
            val rssManagement = getRssSourceUseCase.execute()
            managementPublisher.postValue(
                ManagementUiState(
                    rssManagement
                ),
            )
        }
         */
    }

    fun deleteRss(url:String){
        viewModelScope.launch{
            deleteRssUseCase.execute(url)
        }
        /*
        viewModelScope.launch (Dispatchers.IO){
            deleteRssUseCase.execute(url)
        }
         */
    }

    data class ManagementUiState(
        val rssManagement: List<DomainRss>? = null
        // val rssManagement: List<GetRssSourceUseCase> = emptyList()
    )

}