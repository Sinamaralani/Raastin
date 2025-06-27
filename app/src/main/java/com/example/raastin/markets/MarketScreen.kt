package com.example.raastin.markets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.raastin.R
import com.example.raastin.core.presentation.theme.IranSansX

@Composable
fun MarketsScreen() {
    val viewModel = hiltViewModel<MarketViewModel>()
    val marketList by viewModel.marketWithDetailsList.collectAsState()

    val items = listOf(
        "\uD83D\uDD25 ترند",
        "جدیدترین",
        "به زودی",
        "میم کوین",
        "عامل هوش مصنوعی",
        "اکوسیستم تون",
        "اکوسیستم سویی",
        "اکوسیستم بیس",
    )

    var text by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
                .padding(start = 10.dp)
        )
        {

            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "بازار ها",
                fontWeight = FontWeight.Medium,
                fontFamily = IranSansX,
                fontSize = 26.sp
            )



            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(items) { item ->
                        Text(text = item)
                    }
                }
            }

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .weight(0.6f)
                            .padding(end = 22.dp),
                        onValueChange = { text = it },
                        placeholder = { Text("جستجوی رمز ارز", fontFamily = IranSansX) },
                        value = text,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.search_24px),
                                contentDescription = null
                            )
                        },
                        maxLines = 1
                    )
                    Text(
                        modifier = Modifier.weight(.15f),
                        text = "تتر",
                        fontFamily = IranSansX,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        modifier = Modifier.weight(.15f),
                        text = "تومان",
                        fontFamily = IranSansX,
                        fontWeight = FontWeight.Normal
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("نام")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 6.dp),
                        painter = painterResource(R.drawable.expand_all_24px),
                        contentDescription = null,
                        tint = Color.Gray

                    )
                    Text("قیمت")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        painter = painterResource(R.drawable.expand_all_24px),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                    Text("24h")
                }

            }

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                LazyColumn {
                    items(marketList) { marketWithDetails ->
                        MarketCard(marketWithDetails)
                    }
                }
            }
        }
    }
}


