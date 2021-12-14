package com.pvl.nest.kinoon.feature.movies_screen.data.api

import com.pvl.nest.kinoon.feature.movies_screen.data.toDomain
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie

class MoviesRepositoryImpl(private val moviesRemoteSource: MoviesRemoteSource) :
    MoviesRepository {
    override suspend fun fetchMovies(): List<Movie> {
        return moviesRemoteSource.fetchMovies().results.map { result -> result.toDomain() }
    }
}