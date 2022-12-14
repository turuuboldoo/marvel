package mn.turbo.marvel.data.remote.dto

import com.google.gson.annotations.SerializedName
import mn.turbo.marvel.data.local.entiry.TvShowEntity
import mn.turbo.marvel.domain.model.TvShow

data class TvShowDto(
    @SerializedName("cover_url")
    val coverUrl: String,
    @SerializedName("directed_by")
    val directedBy: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("last_aired_date")
    val lastAiredDate: String,
    @SerializedName("number_episodes")
    val numberEpisodes: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("phase")
    val phase: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("saga")
    val saga: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("trailer_url")
    val trailerUrl: String
) {
    fun toTvShow(): TvShow {
        return TvShow(
            coverUrl = coverUrl,
            directedBy = directedBy,
            id = id,
            imdbId = imdbId,
            lastAiredDate = lastAiredDate,
            numberEpisodes = numberEpisodes,
            overview = overview,
            phase = phase,
            releaseDate = releaseDate,
            saga = saga,
            season = season,
            title = title,
            trailerUrl = trailerUrl
        )
    }

    fun toTvShowEntity(): TvShowEntity {
        return TvShowEntity(
            coverUrl = coverUrl,
            directedBy = directedBy,
            imdbId = imdbId,
            lastAiredDate = lastAiredDate,
            numberEpisodes = numberEpisodes,
            overview = overview,
            phase = phase,
            releaseDate = releaseDate,
            saga = saga,
            season = season,
            title = title,
            trailerUrl = trailerUrl,
            id = id
        )
    }
}

data class TvShowList(
    val data: List<TvShowDto>
)
