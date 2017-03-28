package inteviewthilina.com.mazarinmovie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import inteviewthilina.com.mazarinmovie.R;
import inteviewthilina.com.mazarinmovie.addmoviemodel.MovieAdd;
import inteviewthilina.com.mazarinmovie.rest.ApiClient;
import inteviewthilina.com.mazarinmovie.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddMovie extends AppCompatActivity {

    Button btndatepicker,submit,submitBack;
    int year, month, day;
    Calendar c;
    SimpleDateFormat formatter;
    EditText movieYear,movieName,movieGenre,movieCast,movieScore;

    private Retrofit mAPIService;
    private static final String TAG = "AddMovie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        btndatepicker = (Button) findViewById(R.id.btndatepicker);
        submit = (Button) findViewById(R.id.movieSubmit);
        submitBack = (Button) findViewById(R.id.movieSubmitBack);

        movieYear = (EditText) findViewById(R.id.txtmovieyear);
        movieName = (EditText) findViewById(R.id.txtmoviename);
        movieGenre = (EditText) findViewById(R.id.txtmovieGenre);
        movieCast = (EditText) findViewById(R.id.txtmovieCast);
        movieScore = (EditText) findViewById(R.id.txtmovieScore);

        mAPIService = ApiClient.getClient();

        //calender
        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment_Light)
                .setYearOptional(true);



        btndatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment();
                cdp.show(AddMovie.this.getSupportFragmentManager(), "Material Calendar");
                cdp.setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                    @Override
                    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                        try {

                            formatter = new SimpleDateFormat("dd/MM/yyyy");
                            String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            Date date = formatter.parse(dateInString);
                            movieYear.setText(formatter.format(date).toString());

                        } catch (Exception ex) {
                            movieYear.setText(ex.getMessage().toString());
                        }
                    }
                });
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieYearText = movieYear.getText().toString().trim();
                String movieNameText = movieName.getText().toString().trim();
                String movieGenreText = movieGenre.getText().toString().trim();
                String movieCastText = movieCast.getText().toString().trim();
                Integer movieScoreText = Integer.parseInt(movieScore.getText().toString().trim());;


                if(!TextUtils.isEmpty(movieYearText) && !TextUtils.isEmpty(movieNameText)
                        &&!TextUtils.isEmpty(movieGenreText)&&!TextUtils.isEmpty(movieCastText)
                        &&!TextUtils.isEmpty(Integer.toString(movieScoreText))) {

                    sendPost(movieYearText, movieNameText,movieGenreText,movieCastText,movieScoreText);
                }else{

                    Toast.makeText(AddMovie.this, "Please fill the details",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        submitBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i1);
            }
        });

    }

    private void sendPost(String movieYearText, String movieNameText, String movieGenreText, String movieCastText, Integer movieScoreText) {

        mAPIService.saveMovie(1,movieNameText,movieYearText,true,movieScoreText,movieGenreText,movieCastText).enqueue(new Callback<MovieAdd>() {
            @Override
            public void onResponse(Call<MovieAdd> call, Response<MovieAdd> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieAdd> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {

    }


}


