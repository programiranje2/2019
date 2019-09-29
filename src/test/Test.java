/*
 * Created on Sep 29, 2019
 *
 */
package test;

import java.util.Scanner;

import movies.Director;
import movies.Movie;
import util.Nationality;

public class Test {
    
    public static final Scanner IN = new Scanner(System.in);
    
    public void testKeyboardInput() {
        System.out.print("Enter some text: ");
//        System.out.println("You just entered: " + IN.nextLine());
        System.out.println("You just entered: " + IN.nextLine() +
                '\n' + "(but you could have entered something else as well, like \"Easy Rider\", or " + 23 + ")");
    }
    
    public void testDirectors() {
//        Director dennisHopper = new Director("Dennis Hopper", false, "USA");
        Director dennisHopper = new Director("Dennis Hopper", false, Nationality.USA);
//        System.out.println("dennisHopper: " + dennisHopper);
        System.out.println("dennisHopper: \n" + dennisHopper);
//        System.out.println(dennisHopper.name);                  // No way! name is a private field in Director
        System.out.println(dennisHopper.getName());
        dennisHopper.setName("D. Hopper");
        System.out.println(dennisHopper.getName());
        System.out.println(dennisHopper.getNationality());
        dennisHopper.signalShooting("Action!");
        System.out.println();
        
        Director peterFonda = new Director("Peter Fonda", false, Nationality.USA);
        System.out.println(peterFonda);
    }
    
    public void testMovies() {
        Director dennisHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Director peterFonda = new Director("Peter Fonda", false, Nationality.USA);
        Movie easyRider = new Movie("Easy Rider", 1969, dennisHopper);
        Movie theHiredHand = new Movie("The Hired Hand", 1971, peterFonda);
        System.out.println(easyRider);
        System.out.println(theHiredHand);
    }

}
