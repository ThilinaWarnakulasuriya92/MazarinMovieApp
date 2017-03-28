package inteviewthilina.com.mazarinmovie.rest;

/**
 * Created by thilinaw on 3/23/2017.
 */


import java.util.ArrayList;
import java.util.List;

import inteviewthilina.com.mazarinmovie.addmoviemodel.AddCast;
import inteviewthilina.com.mazarinmovie.addmoviemodel.AddGenre;
import inteviewthilina.com.mazarinmovie.addmoviemodel.MovieAdd;
import inteviewthilina.com.mazarinmovie.model.Movie;
import inteviewthilina.com.mazarinmovie.model.MovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {





    @GET("rest/movies/")
    Call<List<MovieResponse>> getTopRatedMovies();

    @POST("rest/movies/")
    @FormUrlEncoded
    Call<MovieAdd> saveMovie(@Field("id") Integer id,
                            @Field("name") String name,
                            @Field("year") String year,
                            @Field("fiction") Boolean fiction,
                            @Field("score") Integer score,
                            @Field("genre") AddGenre genre,
                            @Field("cast") AddCast cast);



}
