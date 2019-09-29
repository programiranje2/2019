/*
 * Created on Sep 29, 2019
 *
 */
package movies;

public class Movie {
    
    private String title;
    private int year;
    private Director director;
    
    public Movie(String title, int year, Director director) {
        super();
        this.title = title;
        this.year = year;
        this.director = director;
    }
    
    public Movie() {
        super();
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.title + ", " + this.year + '\n' + this.director;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

}
