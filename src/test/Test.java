/*
 * Created on Sep 29, 2019
 *
 */
package test;

import java.util.Scanner;

import movies.Actor;
import movies.Director;
import movies.Movie;
import util.Nationality;
import util.Sex;

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
//        Director dennisHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Director dennisHopper = null;
        Director peterFonda = new Director("Peter Fonda", false, Nationality.USA);
        Movie easyRider = new Movie("Easy Rider", 1969, dennisHopper);
        Movie theHiredHand = new Movie("The Hired Hand", 1971, peterFonda);
        System.out.println(easyRider);
        System.out.println(theHiredHand);
    }
    
    public void testIntegerAndDouble() {
        int i = 2;
        double d = 12.3;
        Integer iI = new Integer(i);
        Double dD = new Double(d);
        System.out.println("When doubleValue() is applied to Integer(2), the result is: " + iI.doubleValue());
        System.out.println("When isInfinite() is applied to Double(2.0), the result is: " + dD.isInfinite());
    }
    
    public void testLoops() {
        int[] a = new int[5];
        System.out.println("for loop:");
        for (int i = 0; i < a.length; i++) {
            if (i == 3) {
//                break;
                continue;
            }
            a[i] = i + 1;
            System.out.println(a[i]);
        }
        System.out.println();
        System.out.println("while loop:");
        int i = 0;
        while (i < a.length) {
            a[i] = i + 1;
            System.out.println(a[i]);
             i = i + 1;
        }
        System.out.println();
        System.out.println("do-while loop:");
        i = 0;
        do {
            a[i] = i + 1;
            System.out.println(a[i]);
             i = i + 1;
        } while (i < a.length);
        System.out.println();
        System.out.println("foreach loop:");
        for (int i1 : a) {
            System.out.println(i1);
        }
    }
    
    public void testSwitch() {
        System.out.print("Read an int: ");
        int a = Integer.parseInt(IN.nextLine());
        switch (a) {
            case 1: System.out.println("Easy Rider"); break;
            case 2: System.out.println("Atomic Blonde"); break;
            default: System.out.println("Another movie");
        }
    }
    
    public void testActor() {
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        System.out.println(peterFonda);
    }
    
    public void testArraysOfObjects() {
        Actor[] actors = new Actor[3];
        // The next 3 lines are a MUST! Without any of them, the for loop below will throw a NullPointerException.
        actors[0] = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        actors[1] = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        actors[2] = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        for (Actor actor : actors) {
            System.out.println(actor.getName());
        }
    }
    
    public void testStatic() {
        System.out.println(Actor.describe());                                                   // typical use of static methods
        System.out.println(Actor.getDefinition());                                              // OK, but not typical
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor charlizeTheron = new Actor("Charlize Theron", Sex.FEMALE, 44, Nationality.USA);
        System.out.println(charlizeTheron.getName() + ": " + charlizeTheron.getDefinition());   // OK, but not typical
        System.out.println(peterFonda.getName() + ": " + peterFonda.getDefinition());           // OK, but not typical
        System.out.println("Now change the definition field for charlizeTheron...");
        charlizeTheron.setDefinition("A person wo can pretend to be somebody else.");           // change static field for ine object
        System.out.println(peterFonda.getName() + ": " + peterFonda.getDefinition());           // all objects share the same static field(s)
    }

}
