package inteviewthilina.com.mazarinmovie.model;

/**
 * Created by thilinaw on 3/23/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    Genre genre;

   Cast cast;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("year")
    private String year;

    @SerializedName("fiction")
    private Boolean fiction;

    @SerializedName("score")
    private Integer score;




    public Movie(Integer id, String name, String year, Boolean fiction, Integer score, Cast cast, Genre genre ) {

        this.id = id;
        this.name = name;
        this.year = year;
        this.fiction = fiction;
        this.score = score;
        this.genre = genre;
        this.cast = cast;


    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Cast getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast = cast;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getFiction() {
        return fiction;
    }

    public void setFiction(Boolean fiction) {
        this.fiction = fiction;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


}
