package com.arthlimchiu.rottenbanana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.arthlimchiu.rottenbanana.core.model.Movie
import com.example.compose.RottenBananaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RottenBananaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RottenBananaApp()
                }
            }
        }
    }
}

@Composable
fun RottenBananaApp() {
    HomeScreen()
}

@Composable
fun HomeScreen(viewModel: MainViewModel = hiltViewModel()) {
    val nowPlayingMovies by viewModel.nowPlayingMovies.collectAsStateWithLifecycle()
    val popularMovies by viewModel.popularMovies.collectAsStateWithLifecycle()
    val topRatedMovies by viewModel.topRatedMovies.collectAsStateWithLifecycle()
    val upcomingMovies by viewModel.upcomingMovies.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        MoviesSection(title = "Now Playing", movies = nowPlayingMovies)
        MoviesSection(title = "Popular", movies = popularMovies)
        MoviesSection(title = "Top Rated", movies = topRatedMovies)
        MoviesSection(title = "Upcoming", movies = upcomingMovies)
    }
}

@Composable
fun MoviesSection(
    title: String,
    modifier: Modifier = Modifier,
    movies: List<Movie> = emptyList()
) {
    Surface(modifier = modifier) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movies) { movie ->
                    MovieCard(posterPath = movie.posterPath)
                }
            }
        }
    }
}

@Composable
fun MovieCard(
    posterPath: String
) {
    Card {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500$posterPath",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 128.dp, height = 200.dp)
        )
    }
}