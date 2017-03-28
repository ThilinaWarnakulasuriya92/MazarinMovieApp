package inteviewthilina.com.mazarinmovie.addmoviemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thilinaw on 3/26/2017.
 */

public class MovieAdd {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("fiction")
    @Expose
    private Boolean fiction;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("genre")
    @Expose
    private AddGenre genre;
    @SerializedName("cast")
    @Expose
    private List<AddCast> cast = null;

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

    public AddGenre getGenre() {
        return genre;
    }

    public void setGenre(AddGenre genre) {
        this.genre = genre;
    }

    public List<AddCast> getCast() {
        return cast;
    }

    public void setCast(List<AddCast> cast) {
        this.cast = cast;
    }

}
