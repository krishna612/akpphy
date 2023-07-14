package j8;

import java.util.ArrayList;
import java.util.List;

public class MovieDB {

    List<Movie> movieList;

    public MovieDB(){
        movieList = new ArrayList<>();
        movieList.add(new Movie(1,"LOR Fellowship",97,2001));
        movieList.add(new Movie(2,"LOR Twin Cities",97,2002));
        movieList.add(new Movie(3,"LOR Return of the King",99,2003));
        movieList.add(new Movie(4,"Usual Suspects",93,1998));
        movieList.add(new Movie(5,"Gladiator",95,1999));
    }

    public List<Movie> getMovieList(){
        return movieList;
    }
}
