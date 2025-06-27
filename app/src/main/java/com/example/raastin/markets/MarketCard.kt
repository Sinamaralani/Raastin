package com.example.raastin.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.raastin.core.data.remote.dto.MarketWithDetails
import com.example.raastin.core.presentation.theme.IranSansX

@Composable
fun MarketCard(marketWithDetails: MarketWithDetails) {
    val markets = marketWithDetails.marketItem
    val details = marketWithDetails.details



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "${details?.change_percent.toString()}%",
                    fontWeight = FontWeight.Medium,
                    fontFamily = IranSansX,
                    textAlign = TextAlign.Right
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "${details?.price} ت",
                    fontFamily = IranSansX,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Right
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.padding(end = 10.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = markets.asset.name_fa,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Right
                    )
                    Text(
                        text = markets.asset.symbol,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Right
                    )
                }
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(markets.asset.logo)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            }

    }
}
