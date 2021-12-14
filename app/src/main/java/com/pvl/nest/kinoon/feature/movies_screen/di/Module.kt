package com.pvl.nest.kinoon.feature.movies_screen.di

import com.pvl.nest.kinoon.feature.movies_screen.data.api.MoviesApi
import com.pvl.nest.kinoon.feature.movies_screen.data.api.MoviesRemoteSource
import com.pvl.nest.kinoon.feature.movies_screen.data.api.MoviesRepository
import com.pvl.nest.kinoon.feature.movies_screen.data.api.MoviesRepositoryImpl
import com.pvl.nest.kinoon.feature.movies_screen.domain.MoviesInteractor
import com.pvl.nest.kinoon.feature.movies_screen.ui.MoviesListViewModel
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val moviesModule = module {
    single<MoviesApi> {
        get<Retrofit>().create()
    }

    single<MoviesRemoteSource> {
        MoviesRemoteSource(get<MoviesApi>())
    }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get<MoviesRemoteSource>())
    }

    single<MoviesInteractor> {
        MoviesInteractor(get<MoviesRepository>())
    }

    viewModel<MoviesListViewModel> {
        MoviesListViewModel(
            get<MoviesInteractor>(),
            get<Router>()
        )
    }
}