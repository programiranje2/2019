/*
 * Created on Oct 27, 2019
 *
 */
package movies;

import java.util.GregorianCalendar;

public class CrimeMovie extends Movie {

    private Subgenre subgenre;

    public CrimeMovie(String title, int year, Director director, Cast cast, GregorianCalendar openingDate, Subgenre subgenre) {
        super(title, year, director, cast, openingDate);
        this.subgenre = subgenre;
    }

    public CrimeMovie(String title, int year, Director director, Subgenre subgenre) {
        super(title, year, director);
        this.subgenre = subgenre;
    }
    
    public CrimeMovie() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSubgenre: " + this.subgenre;
    }

    public Subgenre getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(Subgenre subgenre) {
        this.subgenre = subgenre;
    }
    
}
