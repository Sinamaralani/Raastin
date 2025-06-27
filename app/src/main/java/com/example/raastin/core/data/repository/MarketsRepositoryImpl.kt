package com.example.raastin.core.data.repository

import com.example.raastin.core.data.remote.MarketsApi
import com.example.raastin.core.data.remote.dto.markets.Markets
import com.example.raastin.core.data.remote.dto.marketsDetails.MarketDetails
import com.example.raastin.core.domain.repository.MarketsRepository

class MarketsRepositoryImpl(private val marketsApi: MarketsApi) : MarketsRepository {

    override suspend fun getMarkets(): Markets {
        return marketsApi.getAllMarket()
    }

    override suspend fun getMarketDetails(symbol: String): MarketDetails {
        return marketsApi.getMarketDetails(symbol)
    }
}