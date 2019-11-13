/*
 * Created on Nov 12, 2019
 *
 */
package movies;

import java.util.GregorianCalendar;

public class MovieYearException extends Exception {
    
    private int year;
    private GregorianCalendar openingDate;
    
    public MovieYearException(int year, GregorianCalendar openingDate) {
        super();
        this.year = year;
        this.openingDate = openingDate;
    }
    
    public MovieYearException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Movie year (" + this.year + ") mismatch with opening date (" + this.openingDate.getTime() + ")\n";
    }

}
