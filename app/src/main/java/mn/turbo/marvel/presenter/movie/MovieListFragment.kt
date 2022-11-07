package mn.turbo.marvel.presenter.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mn.turbo.marvel.common.collectLatestLifecycleFlow
import mn.turbo.marvel.databinding.FragmentMovieListBinding
import mn.turbo.marvel.presenter.movie.adapter.MovieAdapter
import mn.turbo.marvel.presenter.movie.viewmodel.MovieViewModel

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter = MovieAdapter { movie ->
            findNavController().navigate(
                MovieListFragmentDirections
                    .actionMovieFragmentToMovieDetailFragment(movie.id)
            )
        }

        binding.recyclerView.adapter = movieAdapter

        collectLatestLifecycleFlow(viewModel.movieListState) { state ->
            binding.progressBar.isVisible = state.isLoading
            movieAdapter.submitList(state.data)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}