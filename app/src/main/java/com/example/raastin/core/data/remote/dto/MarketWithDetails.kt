package com.example.raastin.core.data.remote.dto

import com.example.raastin.core.data.remote.dto.markets.MarketsItem
import com.example.raastin.core.data.remote.dto.marketsDetails.MarketDetails

data class MarketWithDetails(
    val marketItem: MarketsItem,
    val details: MarketDetails?
)
