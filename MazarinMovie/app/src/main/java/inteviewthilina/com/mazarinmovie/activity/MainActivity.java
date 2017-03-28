package inteviewthilina.com.mazarinmovie.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.List;

import java.util.ArrayList;

import inteviewthilina.com.mazarinmovie.R;
import inteviewthilina.com.mazarinmovie.adapter.MoviesAdapter;
import inteviewthilina.com.mazarinmovie.model.Movie;
import inteviewthilina.com.mazarinmovie.model.MovieResponse;
import inteviewthilina.com.mazarinmovie.rest.ApiClient;

import retrofit2.Callback;
import inteviewthilina.com.mazarinmovie.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = " http://codechallenge.mazarin.lk/movieservice/rest/";

    private static final String TAG = MainActivity.class.getSimpleName();

    FloatingActionButton fab; //floating button
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		
		final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
		
		

        Call<List<MovieResponse>> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                int statusCode = response.code();
               //movies= response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.activity_add_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }


        });
        
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                floatingButtonAction();


            }
        });
    }




    private void floatingButtonAction() {

        Intent i = new Intent(getBaseContext(), AddMovie.class);
        startActivity(i);
    }




}
