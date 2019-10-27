/*
 * Created on Oct 27, 2019
 *
 */
package movies;

import java.util.GregorianCalendar;

import util.Vehicle;

public class AwardedRoadMovie extends RoadMovie {
    
    private String awards;

    public AwardedRoadMovie(String title, int year, Director director, Actor[] actors, GregorianCalendar openingDate,
            Vehicle vehicle, String award) {
        super(title, year, director, actors, openingDate, vehicle);
        this.awards = award;
    }

    public AwardedRoadMovie(String title, int year, Director director, Actor[] actors) {
        super(title, year, director, actors);
    }

    public AwardedRoadMovie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate) {
        super(title, year, director, cast, openingDate);
    }

    public AwardedRoadMovie(String title, int year, Director director, Cast cast) {
        super(title, year, director, cast);
    }

    public AwardedRoadMovie(String title, int year, Director director, int noOfActors) {
        super(title, year, director, noOfActors);
    }

    public AwardedRoadMovie(String title, int year, Director director) {
        super(title, year, director);
    }
    
    public void showAwards() {
        System.out.println("Award(s): " + this.awards);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAward(s): " + this.awards;
    }

    public AwardedRoadMovie() {
        super();
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

}
