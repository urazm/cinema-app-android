package ru.fundamental.android.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fundamental.android.learn.data.models.Movie
import ru.fundamental.android.learn.domain.MovieDataSource

class FragmentMoviesList : Fragment() {

    private var recycler: RecyclerView? = null

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? MoviesAdapter)?.apply {
            bindActors(MovieDataSource().getMovies())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = MoviesAdapter()
        recycler?.layoutManager = GridLayoutManager(activity, 2)

        view.postDelayed({        view.findNavController().navigate(R.id.fragmentMoviesDetails)
        },
            3000) // проверка работоспособности компонента навигации


    }
}