package com.pvl.nest.kinoon.feature.movies_screen.data.api

import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie

interface MoviesRepository {
    suspend fun fetchMovies(): List<Movie>
}