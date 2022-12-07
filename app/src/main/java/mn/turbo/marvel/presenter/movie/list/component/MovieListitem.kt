package mn.turbo.marvel.presenter.movie.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import mn.turbo.marvel.domain.model.Movie

@Composable
fun MovieListItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(movie) }
    ) {
        val model = ImageRequest.Builder(LocalContext.current)
            .data(movie.coverUrl)
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .dispatcher(Dispatchers.IO)
            .build()

        AsyncImage(
            model = model,
            contentDescription = movie.title,
            modifier = Modifier.clip(RoundedCornerShape(8.dp))
        )
    }
}
