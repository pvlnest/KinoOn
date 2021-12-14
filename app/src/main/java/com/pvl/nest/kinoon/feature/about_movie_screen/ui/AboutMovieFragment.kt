package com.pvl.nest.kinoon.feature.about_movie_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.pvl.nest.kinoon.databinding.FragmentAboutMovieBinding
import com.pvl.nest.kinoon.R
import com.pvl.nest.kinoon.base.utils.genresToString
import com.pvl.nest.kinoon.base.utils.loadImage
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie
import com.pvl.nest.kinoon.feature.movies_screen.ui.MoviesListViewModel
import com.pvl.nest.kinoon.feature.movies_screen.ui.UiEvent
import com.pvl.nest.kinoon.feature.movies_screen.ui.adapter.movieAdapterDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutMovieFragment : Fragment(R.layout.fragment_about_movie) {
    companion object {
        private const val MOVIE_KEY = "movie"
        fun newInstance(movie: Movie) = AboutMovieFragment().apply {
            arguments = bundleOf(Pair(MOVIE_KEY, movie))
        }
    }

    private val binding: FragmentAboutMovieBinding by viewBinding(FragmentAboutMovieBinding::bind)
    private val movie: Movie by lazy {
        requireArguments().getParcelable(MOVIE_KEY)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cardPoster.loadImage(movie.posterPath)
            cardMovieGenres.text = genresToString(movie.genres)
            cardMovieOverview.text = movie.overview
            cardMovieRating.text = movie.voteAverage.toString()
            cardMovieYear.text = movie.releaseDate
            cardMovieTitle.text = movie.title
        }


    }
}