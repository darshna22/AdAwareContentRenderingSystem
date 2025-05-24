package com.example.adawarecontentrenderingsystem.ui

import LLD_AdAwareContentRenderingSystem.model.Movie
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieItemView(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(text = movie.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text =movie.duration.toString(), fontSize = 14.sp)
    }
}

