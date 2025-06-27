package com.example.raastin.core.data.remote.dto.markets

data class MarketsItem(
    val asset: Asset,
    val base_asset: BaseAsset,
    val bookmark: Boolean,
    val enable: Boolean,
    val id: Int,
    val maker_fee: String,
    val margin_enable: Boolean,
    val max_trade_quantity: String,
    val min_trade_quantity: String,
    val name: String,
    val step_size: Int,
    val strategy_enable: Boolean,
    val taker_fee: String,
    val tick_size: Int
)