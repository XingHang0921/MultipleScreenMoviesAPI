package codepath.com.multiplescreenmoviesapi

import retrofit2.Call
import retrofit2.http.GET
interface MoviesApiInterface {
    @GET("/3/movie/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")

    fun getMovieList() : Call<MovieResponse>
}