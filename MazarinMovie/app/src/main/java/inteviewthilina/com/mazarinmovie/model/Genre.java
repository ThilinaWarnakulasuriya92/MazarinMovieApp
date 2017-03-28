package inteviewthilina.com.mazarinmovie.model;

/**
 * Created by thilinaw on 3/23/2017.
 */

public class Genre {

    String name;
    Integer id;

    public Genre(String name, Integer id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
