package com.example.raastin.core.data.remote

import com.example.raastin.core.data.remote.dto.markets.Markets
import com.example.raastin.core.data.remote.dto.marketsDetails.MarketDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketsApi {

    @GET("market/symbols/{symbol}")
    suspend fun getMarketDetails(@Path("symbol") symbol: String): MarketDetails

    @GET("market/symbols/?base_asset=IRT")
    suspend fun getAllMarket(): Markets
}