/*
 * Created on Sep 29, 2019
 *
 */
package movies;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Movie {
    
    protected String title;
    protected int year;
    protected Director director;
    protected Actor[] actors;
    protected GregorianCalendar openingDate;
    
    public Movie(String title, int year, Director director, Actor[] actors, GregorianCalendar openingDate) {
        super();
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.openingDate = openingDate;
    }

    public Movie(String title, int year, Director director, Actor[] actors) {
        super();
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }
    
    public Movie(String title, int year, Director director, Cast cast) {
        this(title, year, director, cast.toArray());
    }

    public Movie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate) {
        this(title, year, director, cast.toArray(), openingDate);
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
    
    public Movie(String title, int year, Director director, int noOfActors) {
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
        if (noOfActors >= 0) {
            this.actors = new Actor[noOfActors];
            for (int i = 0; i < actors.length; i++) {
                this.actors[i] = new Actor();
            }
        }
    }
    
    public Movie() {
        super();
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
//        return this.title + ", " + this.year + '\n' + this.director;
        String[] actorNames = new String[this.actors.length];
        int i = 0;
        for (Actor actor : this.actors) {
            actorNames[i] = actor.getName();
            i++;
        }
//        return this.title + ", " + this.year + '\n' + this.director + "\nStarring: " + String.join(", ", actorNames);
        return this.title + ", " + this.year + '\n' + this.director + 
                "\nStarring: " + String.join(", ", actorNames) + 
                "\nOpening date: " + (new SimpleDateFormat("EEE, MMM dd, yyyy").format(this.openingDate.getTime()));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie m = (Movie) obj;
        if (!((m.title.equals(this.title) && (m.director.equals(this.director) && (m.year == this.year))))) {
            return false;
        }
        return true;
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

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public GregorianCalendar getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(GregorianCalendar openingDate) {
        this.openingDate = openingDate;
    }

}
