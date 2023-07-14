package j8;

public class Movie {
    private int id;
    private String name;
    private int rankScore;
    private int year;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRankScore() {
        return rankScore;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", name: ");
        sb.append(this.name);
        sb.append(", rankscore: ");
        sb.append(this.rankScore);
        sb.append(", year: ");
        sb.append((this.year));
        sb.append(";");
        return sb.toString();
    }

    public Movie(int id, String name, int rankScore, int year){
        this.id = id;
        this.name = name;
        this.rankScore = rankScore;
        this.year  = year;
    }
}
