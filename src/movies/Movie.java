/*
 * Created on Sep 29, 2019
 *
 */
package movies;

public class Movie {
    
    private String title;
    private int year;
    private Director director;
    private Actor[] acctors;
    
    public Movie(String title, int year, Director director, Actor[] starring) {
        super();
        this.title = title;
        this.year = year;
        this.director = director;
        this.acctors = starring;
    }

    public Movie(String title, int year, Director director) {
        super();
        if ((title != null) && (title != "")) {
            this.title = title;
        } else {
            System.out.println("Error: a movie title cannot be null or empty string.");
        }
        if ((year >= 1893) && (year <=2019)) {
            this.year = year;
        } else {
            System.out.println("Error: a movie could have been released only between 1893 and 2019.");
        }
        if (director != null) {
            this.director = director;
        } else {
            System.out.println("Error: a movie director cannot be null.");
        }
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
        if ((title != null) && (title != "")) {
            this.title = title;
        } else {
            System.out.println("Error: a movie title cannot be null or empty string.");
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if ((year >= 1893) && (year <=2019)) {
            this.year = year;
        } else {
            System.out.println("Error: a movie could have been released only between 1893 and 2019.");
        }
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        if (director != null) {
            this.director = director;
        } else {
            System.out.println("Error: a movie director cannot be null.");
        }
    }

    public Actor[] getStarring() {
        return acctors;
    }

    public void setStarring(Actor[] starring) {
        this.acctors = starring;
    }

}
