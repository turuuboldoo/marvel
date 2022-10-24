package mn.turbo.marvel.presenter.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import mn.turbo.marvel.R
import mn.turbo.marvel.common.collectLatestLifecycleFlow
import mn.turbo.marvel.databinding.FragmentMovieDetailBinding
import mn.turbo.marvel.presenter.movie.viewmodel.MovieDetailViewModel

class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieDetailViewModel by viewModels()

    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it)
                .movieId
        }

        viewModel.getMovieDetail(movieId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_detail, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectLatestLifecycleFlow(viewModel.movieListState) { state ->
            binding.movie = state.movie
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}