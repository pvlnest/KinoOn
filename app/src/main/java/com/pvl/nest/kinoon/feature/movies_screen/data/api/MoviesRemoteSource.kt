package com.pvl.nest.kinoon.feature.movies_screen.data.api

import com.pvl.nest.kinoon.feature.movies_screen.data.api.model.ResultsRemoteModel

class MoviesRemoteSource(private val moviesApi: MoviesApi) {
    suspend fun fetchMovies(): ResultsRemoteModel = moviesApi.fetchMovies()
}