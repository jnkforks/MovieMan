package com.calvinnor.movie.details.domain

import com.calvinnor.core.extensions.toDataResult
import com.calvinnor.data.movie.local.dao.MovieDao
import com.calvinnor.data.movie.local.entities.MovieL

class MovieDetailsLocal(
    private val movieDao: MovieDao

) : MovieDetailsC.Local {

    override suspend fun getMovieDetails(movieId: String) =
        movieDao.getMovieDetails(movieId).toDataResult()

    override suspend fun saveMovieDetails(movie: MovieL) = movieDao.insert(movie)

}
