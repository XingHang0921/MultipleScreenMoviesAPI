package codepath.com.multiplescreenmoviesapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter( private val movies: List<Movie>):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) :RecyclerView.ViewHolder(view){
        private val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie:Movie)
        {
            itemView.movieTitle.text = movie.title
            Glide.with(itemView).load(IMAGE_BASE_URL + movie.poster).into(itemView.movie_poster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}


