/*
 * Created on Sep 29, 2019
 *
 */
package movies;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Movie implements Serializable {
    
    static final long serialVersionUID = 4111L;
    
    protected String title;
    protected int year;
    protected Director director;
    protected Actor[] actors;
    protected GregorianCalendar openingDate;
    
    public Movie(String title, int year, Director director, Actor[] actors, GregorianCalendar openingDate) throws MovieYearException {
        super();
        if (year != openingDate.get(Calendar.YEAR)) {
            throw new MovieYearException(year, openingDate);
        }
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

    public Movie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate) throws MovieYearException {
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
    
    public void serialize(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))))) {
            out.writeObject(this);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static Movie deserialize(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filename))))) {
            return (Movie) in.readObject();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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
//        return this.title + ", " + this.year + '\n' + this.director + 
//                "\nStarring: " + String.join(", ", actorNames) + 
//                "\nOpening date: " + this.openingDate != null ? (new SimpleDateFormat("EEE, MMM dd, yyyy").format(this.openingDate.getTime())) : "unknown";
        String openingDate = this.openingDate != null ? (new SimpleDateFormat("EEE, MMM dd, yyyy").format(this.openingDate.getTime())) : "unknown";
        return this.title + ", " + this.year + '\n' + this.director + 
                "\nStarring: " + String.join(", ", actorNames) + 
                "\nOpening date: " + openingDate;

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
