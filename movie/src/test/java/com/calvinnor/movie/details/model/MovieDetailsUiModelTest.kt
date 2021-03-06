package com.calvinnor.movie.details.model

import com.calvinnor.data.movie.local.entities.MovieL
import com.calvinnor.data.movie.remote.api.MovieR
import com.calvinnor.movie.commons.business.buildImagePath
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Tests the conversion from Local / Remote models to UiModels
 */
class MovieDetailsUiModelTest {

    @Test
    fun convertRemoteToUiModel() {
        val remoteUiModel = MovieDetailsUiModel(TEST_REMOTE_MOVIE)

        assertEquals("Hello World", remoteUiModel.title)
        assertEquals("A new program written in Kotlin emerges", remoteUiModel.description)

        assertEquals(
            buildImagePath("https://kotlinlang.org/backdrop.png"),
            remoteUiModel.backdropImage
        )
        assertEquals(
            buildImagePath("https://kotlinlang.org/poster.png"),
            remoteUiModel.posterImage
        )
        assertEquals(
            "2019", remoteUiModel.releaseYear
        )
    }

    @Test
    fun convertLocalToUiModel() {
        val localUiModel = MovieDetailsUiModel(TEST_LOCAL_MOVIE)

        assertEquals("Hello World", localUiModel.title)
        assertEquals("A new program written in Kotlin emerges", localUiModel.description)

        assertEquals(
            buildImagePath("https://kotlinlang.org/backdrop.png"),
            localUiModel.backdropImage
        )
        assertEquals(
            buildImagePath("https://kotlinlang.org/poster.png"),
            localUiModel.posterImage
        )
        assertEquals(
            "2019", localUiModel.releaseYear
        )
    }

    companion object {

        private val TEST_DATE = Calendar.getInstance().apply { set(Calendar.YEAR, 2019) }.time

        private val TEST_REMOTE_MOVIE = MovieR(
            id = 2,
            title = "Hello World",
            overview = "A new program written in Kotlin emerges",
            backdropPath = "https://kotlinlang.org/backdrop.png",
            posterPath = "https://kotlinlang.org/poster.png",
            releaseDate = TEST_DATE
        )

        private val TEST_LOCAL_MOVIE = MovieL(
            id = 2,
            title = "Hello World",
            overview = "A new program written in Kotlin emerges",
            backdropPath = "https://kotlinlang.org/backdrop.png",
            posterPath = "https://kotlinlang.org/poster.png",
            releaseDate = TEST_DATE
        )

    }
}
