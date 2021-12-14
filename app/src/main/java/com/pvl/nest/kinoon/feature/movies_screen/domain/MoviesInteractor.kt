package com.pvl.nest.kinoon.feature.movies_screen.domain

import com.pvl.nest.kinoon.base.funcs.attempt
import com.pvl.nest.kinoon.feature.movies_screen.data.api.MoviesRepository

class MoviesInteractor(private val moviesRepository: MoviesRepository) {
    suspend fun fetchMovies() = attempt {
        moviesRepository.fetchMovies()
    }
}