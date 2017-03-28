package inteviewthilina.com.mazarinmovie.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import inteviewthilina.com.mazarinmovie.R;
import inteviewthilina.com.mazarinmovie.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieYear;
        TextView movieGenere;
        TextView movieCast;
        TextView movieFiction;
        TextView movieScore;


        public MovieViewHolder(View v) {
            super(v);

            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.movieTitle);
            movieYear = (TextView) v.findViewById(R.id.movieYear);
           // movieGenere = (TextView) v.findViewById(R.id.description);
            movieCast = (TextView) v.findViewById(R.id.movieCast);
            movieFiction = (TextView) v.findViewById(R.id.movieFiction);
            movieScore = (TextView) v.findViewById(R.id.movieScore);

        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        holder.movieTitle.setText(movies.get(position).getName());
        holder.movieYear.setText(movies.get(position).getYear());
        holder.movieCast.setText((CharSequence) movies.get(position).getCast());
        holder.movieFiction.setText(movies.get(position).getFiction().toString());
        holder.movieScore.setText(movies.get(position).getScore().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}