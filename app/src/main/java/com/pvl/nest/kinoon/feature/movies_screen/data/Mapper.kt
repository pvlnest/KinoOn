package com.pvl.nest.kinoon.feature.movies_screen.data

import com.pvl.nest.kinoon.feature.movies_screen.data.api.model.GenreRemoteModel
import com.pvl.nest.kinoon.feature.movies_screen.data.api.model.ResultRemoteModel
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Genre
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie

fun GenreRemoteModel.toDomain(): Genre = Genre(name = name)

fun ResultRemoteModel.toDomain(): Movie {
    val genres: List<Genre> = genres.map { genre -> genre.toDomain() }

    return Movie(
        id = id,
        posterPath = posterPath,
        title = title,
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        genres = genres,
        overview = overview,
        video = video
    )
}