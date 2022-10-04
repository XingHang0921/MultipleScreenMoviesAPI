package codepath.com.multiplescreenmoviesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.setHasFixedSize(true)
        getMovieData { movies:List<Movie>->
                        rvMovies.adapter = MovieAdapter(movies)
        }

    }


    private fun getMovieData(callback:(List<Movie>)->Unit){
        val apiService = MoviesApiService.getInstance().create(MoviesApiInterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
    }
}