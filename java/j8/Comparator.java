package j8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {
    public  static  void main(String[] args){
        List<Movie> movieList = new MovieDB().getMovieList();
        System.out.println("before sorting");
        System.out.println(movieList);
        System.out.println("sort by name");
        Collections.sort(movieList,(m1, m2)->m1.getName().compareTo(m2.getName()));
        System.out.println(movieList);
        System.out.println("sort by rankscore, top first");
        Collections.sort(movieList,(m1,m2)->m2.getRankScore()-m1.getRankScore());
        System.out.println(movieList);
    }
}
