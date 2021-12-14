package com.pvl.nest.kinoon.feature.movies_screen.ui.adapter

import com.pvl.nest.kinoon.base.utils.formatDate
import com.pvl.nest.kinoon.base.utils.loadImage
import com.pvl.nest.kinoon.base.utils.setThrottledClickListener
import com.pvl.nest.kinoon.databinding.MovieItemBinding
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Genre
import com.pvl.nest.kinoon.feature.movies_screen.domain.model.Movie
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.pvl.nest.kinoon.feature.about_movie_screen.ui.AboutMovieFragment

fun movieAdapterDelegate( onInfoButtonClick: (movie: Movie) -> Unit, onPlayButtonClick: (movie: Movie) -> Unit) =

    adapterDelegateViewBinding<Movie, Movie, MovieItemBinding>(
        { layoutInflater, parent ->
            MovieItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        with(binding) {

            linearLayout.setThrottledClickListener {
                onInfoButtonClick(item)
            }

            moviePlay.setThrottledClickListener {
                onPlayButtonClick(item)
            }
        }

        bind {
            binding.apply {
                moviePoster.loadImage(item.posterPath)
                moviePosterTitle.text = item.title
                moviePosterDate.text = formatDate(item.releaseDate)
                moviePosterRate.text = item.voteAverage.toString()

                val genre:Genre = item.genres[0];
                val genreStr:String = genre.name;

                movieGenre.text = genreStr;
            }
        }
    }