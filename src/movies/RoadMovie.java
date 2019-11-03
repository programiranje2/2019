/*
 * Created on Oct 27, 2019
 *
 */
package movies;

import java.util.GregorianCalendar;

import util.Vehicle;

public class RoadMovie extends Movie {
    
    protected Vehicle vehicle;

    public RoadMovie(String title, int year, Director director, Actor[] actors, GregorianCalendar openingDate, Vehicle vehicle) {
        super(title, year, director, actors, openingDate);
        this.vehicle = vehicle;
    }

    public RoadMovie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate,
            Vehicle vehicle) {
        super(title, year, director, cast, openingDate);
        this.vehicle = vehicle;
    }

    public RoadMovie(String title, int year, Director director, Actor[] actors) {
        super(title, year, director, actors);
    }

    public RoadMovie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate) {
        super(title, year, director, cast, openingDate);
    }

    public RoadMovie(String title, int year, Director director, Cast cast) {
        super(title, year, director, cast);
    }

    public RoadMovie(String title, int year, Director director, int noOfActors) {
        super(title, year, director, noOfActors);
    }

    public RoadMovie(String title, int year, Director director) {
        super(title, year, director);
    }

    public RoadMovie() {
        super();
    }
    
    public void showOneLineDescription(String text) {
        System.out.println(text);
    }
    
    public void showOneLineDescription(String text, boolean extended) {
        if (extended) {
            System.out.println(text + " (directed by " + this.getDirector().getName() + ", " + this.getYear() + ")");
        } else {
            System.out.println(text);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nVehicle: " + this.vehicle;
//        return super.toString() + "\nVehicle: " + this.vehicle + this.title;  // doesn't compile if title is private, change it to protected
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
