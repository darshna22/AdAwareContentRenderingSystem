package com.example.adawarecontentrenderingsystem

import LLD_AdAwareContentRenderingSystem.AdsOperator
import LLD_AdAwareContentRenderingSystem.enums.AdsPolicyType
import LLD_AdAwareContentRenderingSystem.model.MainContentItem
import LLD_AdAwareContentRenderingSystem.model.Movie
import LLD_AdAwareContentRenderingSystem.model.MovieAd
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adawarecontentrenderingsystem.ui.MainContentList
import com.example.adawarecontentrenderingsystem.ui.theme.AdAwareContentRenderingSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdAwareContentRenderingSystemTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun movieList(): List<MainContentItem> {
    val movieList =
        listOf(
            Movie("Movie1", 12, "1"),
            Movie("Movie2", 12, "2"),
            Movie("Movie3", 12, "3"),
            Movie("Movie4", 12, "4"),
            Movie("Movie5", 12, "5"),
            Movie("Movie6", 12, "3"),
            Movie("Movie7", 12, "4"),
            Movie("Movie8", 12, "5")
        )
    val adsList =
        listOf(
            MovieAd("Ads1", 12, "1"),
            MovieAd("Ads2", 12, "2"),
            MovieAd("Ads3", 12, "3"),
            MovieAd("Ads4", 12, "4")
        )
    val movieItemList = movieList.map {
        MainContentItem.MovieItem(it)
    }

    val adsItemList = adsList.map {
        MainContentItem.AdsItem(it)
    }


    val resultList = AdsOperator().getAdsPolicy(AdsPolicyType.INTERVAL_ADS_POLICY, 1)
        .applyPolicy(movieItemList, adsItemList)

    resultList.forEach { data ->
        when (data) {
            is MainContentItem.MovieItem -> println(data.movie.name)
            is MainContentItem.AdsItem -> println(data.ads.name)
        }
    }

    println("================================================================")

    val resultList1 = AdsOperator().getAdsPolicy(AdsPolicyType.START_ADS_POLICY)
        .applyPolicy(movieItemList, adsItemList)

    resultList1.forEach { data ->
        when (data) {
            is MainContentItem.MovieItem -> println(data.movie.name)
            is MainContentItem.AdsItem -> println(data.ads.name)
        }
    }

    println("================================================================")
    val resultList3 = AdsOperator().getAdsPolicy(AdsPolicyType.END_ADS_POLICY)
        .applyPolicy(movieItemList, adsItemList)

    resultList3.forEach { data ->
        when (data) {
            is MainContentItem.MovieItem -> println(data.movie.name)
            is MainContentItem.AdsItem -> println(data.ads.name)
        }
    }

    return resultList
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    AdAwareContentRenderingSystemTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainContentList(
                movieList(),
                Modifier.padding(
                    vertical = innerPadding.calculateTopPadding()
                        .coerceAtLeast(innerPadding.calculateBottomPadding())
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdAwareContentRenderingSystemTheme {
        Greeting()
    }
}