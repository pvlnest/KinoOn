package com.pvl.nest.kinoon.base.nav

import com.pvl.nest.kinoon.feature.about_movie_screen.ui.AboutMovieFragment
import com.pvl.nest.kinoon.feature.errors_screen.ui.ErrorsScreenFragment
import com.pvl.nest.kinoon.feature.movie_player_screen.ui.MoviePlayerFragment
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie
import com.pvl.nest.kinoon.feature.movies_screen.ui.MoviesListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun movieListScreen() = FragmentScreen {
        MoviesListFragment.newInstance()
    }

    fun aboutMovie(movie: Movie) = FragmentScreen {
        AboutMovieFragment.newInstance(movie)
    }

    fun moviePlayer(movie: Movie) = FragmentScreen {
        MoviePlayerFragment.newInstance(movie)
    }

    fun errorsScreen() = FragmentScreen {
        ErrorsScreenFragment.newInstance()
    }
}