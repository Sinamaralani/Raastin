package com.example.raastin.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raastin.core.data.remote.dto.MarketWithDetails
import com.example.raastin.core.domain.repository.MarketsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@HiltViewModel
class MarketViewModel @Inject constructor(private val repository: MarketsRepository) : ViewModel() {

    private val _marketWithDetailsList = MutableStateFlow<List<MarketWithDetails>>(emptyList())
    val marketWithDetailsList: StateFlow<List<MarketWithDetails>> = _marketWithDetailsList

    private var updateJob: Job? = null

    init {
        startAutoRefresh()
    }

    private fun startAutoRefresh() {
        updateJob?.cancel()
        updateJob = viewModelScope.launch {
            while (isActive) {
                try {
                    val markets = repository.getMarkets()
                    val detailedList = markets.map { market ->
                        val details = try {
                            repository.getMarketDetails(market.name)
                        } catch (e: Exception) {
                            null
                        }
                        MarketWithDetails(market, details)
                    }

                    _marketWithDetailsList.value = detailedList
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                delay(5000)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        updateJob?.cancel()
    }

}