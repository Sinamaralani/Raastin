package com.example.raastin.core.data.remote.dto.marketsDetails

data class MarketDetails(
    val asset: Asset,
    val base_asset: BaseAsset,
    val base_volume: String,
    val bookmark: Boolean,
    val change: String,
    val change_percent: String,
    val enable: Boolean,
    val high: String,
    val low: String,
    val name: String,
    val price: String,
    val volume: String
)