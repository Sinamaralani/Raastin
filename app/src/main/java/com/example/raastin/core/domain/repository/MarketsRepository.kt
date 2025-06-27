package com.example.raastin.core.domain.repository

import com.example.raastin.core.data.remote.dto.markets.Markets
import com.example.raastin.core.data.remote.dto.marketsDetails.MarketDetails

interface MarketsRepository {

    suspend fun getMarkets(): Markets

    suspend fun getMarketDetails(symbol: String): MarketDetails

}