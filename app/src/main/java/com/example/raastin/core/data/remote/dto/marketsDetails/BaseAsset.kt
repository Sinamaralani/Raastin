package com.example.raastin.core.data.remote.dto.marketsDetails

data class BaseAsset(
    val id: Int,
    val logo: String,
    val name: String,
    val name_fa: String,
    val original_name_fa: String,
    val original_symbol: String,
    val otc_status: String,
    val precision: Int,
    val price_page: Boolean,
    val step_size: Int,
    val symbol: String,
    val trading_view_symbol: String
)