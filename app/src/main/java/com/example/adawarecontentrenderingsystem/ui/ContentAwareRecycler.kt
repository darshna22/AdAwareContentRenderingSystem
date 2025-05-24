package com.example.adawarecontentrenderingsystem.ui/*
package com.example.adawarecontentrenderingsystem.ui.content_aware

import LLD_AdAwareContentRenderingSystem.model.MainContentItem
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView


class ContentAwareRecycler(private val contentList: List<MainContentItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_MOVIE = 1
        private const val VIEW_TYPE_ADS = 2
    }

    override fun getItemViewType(position: Int): Int {
        val viewType = when (contentList[position]) {
            is MainContentItem.MovieItem -> VIEW_TYPE_MOVIE
            is MainContentItem.AdsItem -> VIEW_TYPE_ADS
        }
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = when (viewType) {
            VIEW_TYPE_MOVIE -> MovieViewHolder(ComposeView(parent.context))
            VIEW_TYPE_ADS -> AdsViewHolder(ComposeView(parent.context))
            else -> throw IllegalArgumentException("Invalid view type")
        }
        return view
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (contentList[position]) {
            is MainContentItem.MovieItem -> {
                val mainViewHolder = (holder as MovieViewHolder)
                mainViewHolder.bind(contentList[position] as MainContentItem.MovieItem)
            }

            is MainContentItem.AdsItem -> {
                val adsViewHolder = (holder as AdsViewHolder)
                adsViewHolder.bind(contentList[position] as MainContentItem.AdsItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    class MovieViewHolder(private val composeView: ComposeView) :
        RecyclerView.ViewHolder(composeView) {
        // Bind data to the views in the movie item layout
        fun bind(movieItem: MainContentItem.MovieItem) {
            composeView.setContent {
                MovieItemView(movie = movieItem.movie)
            }
        }
    }

    class AdsViewHolder(private val composeView: ComposeView) :
        RecyclerView.ViewHolder(composeView) {
        fun bind(adsItem: MainContentItem.AdsItem) {
            composeView.setContent {
                AdsItemView(movieAd = adsItem.ads)
            }
        }
    }

}*/
