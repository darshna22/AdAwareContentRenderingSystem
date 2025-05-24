package com.example.adawarecontentrenderingsystem.ui

import LLD_AdAwareContentRenderingSystem.model.MainContentItem
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainContentList(mainContentIemList: List<MainContentItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.background(Color.Cyan)) {
        items(mainContentIemList) { item ->
            when (item) {
                is MainContentItem.MovieItem -> MovieItemView(item.movie)
                is MainContentItem.AdsItem -> AdsItemView(item.ads)
            }
        }
    }
}
