package dev.mustaq.coronaapp.ui.main

import androidx.lifecycle.*
import dev.mustaq.coronaapp.enums.Status
import dev.mustaq.coronaapp.models.CoronaStatsModel
import dev.mustaq.coronaapp.repository.CoronaRepository
import dev.mustaq.coronaapp.utils.Resource
import kotlinx.coroutines.launch


/**
 * Created by Mustaq Sameer on 02/06/20
 */

class MainViewModel(
    private val coronaRepository: CoronaRepository
) : ViewModel() {

    private val coronaStatsLd = MutableLiveData<CoronaStatsModel>()
    private val errorLD = MutableLiveData<String>()

    val coronaStats: LiveData<CoronaStatsModel> = coronaStatsLd
    val error: LiveData<String> = errorLD

    fun getCoronaStat() {
        viewModelScope.launch {
            val response : Resource<CoronaStatsModel> = coronaRepository.getCoronaStats()
            when(response.status) {
                Status.SUCCESS -> { coronaStatsLd.value = response.data }
                Status.ERROR -> { errorLD.value = response.message}
            }
        }
    }

}