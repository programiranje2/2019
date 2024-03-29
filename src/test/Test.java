/*
 * Created on Sep 29, 2019
 *
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import movies.Actor;
import movies.AwardedRoadMovie;
import movies.Cast;
import movies.CrewMember;
import movies.CrimeMovie;
import movies.Director;
import movies.Movie;
import movies.MovieYearException;
import movies.PerformingArt;
import movies.PerformingArtist;
import movies.RoadMovie;
import movies.Subgenre;
import util.Nationality;
import util.Sex;
import util.Utility;
import util.Vehicle;

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
        i = 0;
        System.out.println("foreach loop:");
        for (int i1 : a) {
            a[i] = i1 + 10;
            System.out.println(a[i]);
            i++;
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
//        Actor peterFonda = new Actor();
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
        System.out.println();
        Director dennisHopper = new Director("Dennis Hopper", false, Nationality.USA);
//        Movie easyRiderWithActors = new Movie("Easy Rider", 1969, dennisHopper, actors);
        Movie easyRider = new Movie("Easy Rider", 1969, dennisHopper, actors.length);
        for (int i = 0; i < actors.length; i++) {
            easyRider.getActors()[i] = actors[i];
            System.out.println(easyRider.getActors()[i]);
        }
        System.out.println();
        System.out.println(easyRider);
//        int i = 0;
//        for (Actor actor : easyRider.getActors()) {
////            System.out.println(actor);
//            actor = actors[i];
//            System.out.println(actor);
//            i++;
//        }
    }
    
    public void testStatic() {
        System.out.println(Actor.describe());                                                   // typical use of static methods
        System.out.println(Actor.getDefinition());                                              // OK, but not typical
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor charlizeTheron = new Actor("Charlize Theron", Sex.FEMALE, 44, Nationality.USA);
        System.out.println(charlizeTheron.getName() + ": " + charlizeTheron.getDefinition());   // OK, but not typical
        System.out.println(peterFonda.getName() + ": " + peterFonda.getDefinition());           // OK, but not typical
        System.out.println("Now change the definition field for charlizeTheron...");
        charlizeTheron.setDefinition("A person wo can pretend to be somebody else.");           // change static field for one object
        System.out.println(peterFonda.getName() + ": " + peterFonda.getDefinition());           // all objects share the same static field(s)
    }
    
    public void testStrings() {
        String easyRider = "Easy Rider";
        System.out.println(easyRider);
        System.out.println(easyRider.charAt(5));
        System.out.println(easyRider.concat(" was released in 1969."));
        System.out.println(easyRider.substring(5, easyRider.length()));
        System.out.println(easyRider.startsWith("Easy"));
        System.out.println(easyRider.endsWith("Rider"));
        String[] words = easyRider.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println(String.join(" ", words));
        System.out.println(easyRider.substring(0, 4));                                          // prints "Easy" (from startIndex to endIndex - 1)
        System.out.println(Integer.parseInt("12"));
        System.out.println(String.valueOf(12));
        System.out.println(String.format("%s%.3f", "String.format, 3 fraction digits: ", (double) 7/6));
        System.out.printf("%s%.3f", "System.out.printf, 3 fraction digits: ", (double) 7/6);
    }
    
    public void testStringBuffers() {
        StringBuffer easyRider = new StringBuffer();
        System.out.println(easyRider);
        easyRider.append("Easy Rider");
        System.out.println(easyRider);
        System.out.println(easyRider.append(" was released in "));
        System.out.println(easyRider.append(1969).append('.'));
        System.out.println(easyRider.delete(11, 15));
        System.out.println(easyRider.insert(11, '(').insert(easyRider.length() - 1, ')'));
    }
    
    public void testNumberFormatting() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        System.out.println(nf.format((double) 6/7));
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format((double) 6/7));
    }
    
    public void testArrayLists() {
//        ArrayList<String> actorNames = new ArrayList<String>();
//        System.out.println(actorNames);
//        actorNames.add("Jack Nicholson");
//        System.out.println(actorNames);
//        actorNames.add("Peter Fonda");
//        System.out.println(actorNames);
//        System.out.println(String.join(", ", actorNames.toArray(new String[actorNames.size()])));
//        System.out.println(actorNames.get(0));
//        actorNames.remove(0);
//        System.out.println(actorNames);
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        Movie easyRider = new Movie("Easy Rider", 1969, dHopper, easyRiderCast);
        System.out.println(easyRider);
    }
    
    public void testGregorianCalendar() {
//        GregorianCalendar c = new GregorianCalendar();
//        System.out.println(c);
//        System.out.println(c.getTime());
//        System.out.println();
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        Movie easyRider;
        try {
            easyRider = new Movie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12));
            System.out.println(easyRider);
            System.out.println();
            if (easyRider.getOpeningDate().before(new GregorianCalendar(2000, 0, 1))) {
                System.out.println("It was long ago...");
            } else {
                System.out.println("");
            }
        } catch (MovieYearException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void testInheritance() {
        Actor alPacino = new Actor("Al Pacino", Sex.MALE, 79, Nationality.USA);
        Actor marlonBrando = new Actor("Marlon Brando", Sex.MALE, -1, Nationality.USA);
        Director francesFordCoppola = new Director("Frances Ford Coppola", true, Nationality.USA);
        Actor[] actors = {alPacino, marlonBrando};
        Movie theGodfather = null;
        try {
            theGodfather = new Movie("The Godfather", 1970, francesFordCoppola, actors, new GregorianCalendar(1972, 2, 14));
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        RoadMovie easyRider;
        CrimeMovie bodyHeat;
        AwardedRoadMovie eR;
        try {
            easyRider = new RoadMovie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12), Vehicle.BIKE);
            
            Actor williamHurt = new Actor("William Hurt", Sex.MALE, 70, Nationality.USA);
            Actor kathleenTurner = new Actor("Kathleen Turner", Sex.FEMALE, 60, Nationality.USA);
            Director lawrenceKasdan = new Director("Lawrence Kasdan", true, Nationality.USA);
            Cast bodyHeatCast = new Cast();
            easyRiderCast.addActor(williamHurt);
            easyRiderCast.addActor(kathleenTurner);
            bodyHeat = new CrimeMovie("Body Heat", 1981, lawrenceKasdan, bodyHeatCast, new GregorianCalendar(1981, 4, 22), Subgenre.FILM_NOIR);
            
            eR = new AwardedRoadMovie("Easy Rider", 1969, dHopper, actors1, new GregorianCalendar(1969, 6, 12), Vehicle.BIKE, "Best First Work");
            
            System.out.println(theGodfather);
            System.out.println(easyRider);
            System.out.println(eR);
            System.out.println(bodyHeat);
            
//        easyRider.getAwards();           // No way!!! easyRider is a RoadMovie, and RoadMovie doesn't have getAwards()
            eR.getAwards();                 // this is OK
            eR.getTitle();                  // this is also OK, because of the inheritance
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public void testPolymorphism() {
        Actor alPacino = new Actor("Al Pacino", Sex.MALE, 79, Nationality.USA);
        Actor marlonBrando = new Actor("Marlon Brando", Sex.MALE, -1, Nationality.USA);
        Director francesFordCoppola = new Director("Frances Ford Coppola", true, Nationality.USA);
        Actor[] actors = {alPacino, marlonBrando};
        Movie theGodfather = null;
        try {
            theGodfather = new Movie("The Godfather", 1970, francesFordCoppola, actors, new GregorianCalendar(1972, 2, 14));
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        try {
            RoadMovie easyRider = new RoadMovie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12), Vehicle.BIKE);
            
            Actor williamHurt = new Actor("William Hurt", Sex.MALE, 70, Nationality.USA);
            Actor kathleenTurner = new Actor("Kathleen Turner", Sex.FEMALE, 60, Nationality.USA);
            Director lawrenceKasdan = new Director("Lawrence Kasdan", true, Nationality.USA);
            Cast bodyHeatCast = new Cast();
            easyRiderCast.addActor(williamHurt);
            easyRiderCast.addActor(kathleenTurner);
            CrimeMovie bodyHeat = new CrimeMovie("Body Heat", 1981, lawrenceKasdan, bodyHeatCast, new GregorianCalendar(1981, 4, 22), Subgenre.FILM_NOIR);
            
            AwardedRoadMovie eR = new AwardedRoadMovie("Easy Rider", 1969, dHopper, actors1, new GregorianCalendar(1969, 6, 12), Vehicle.BIKE, "Best First Work");
            
            Movie[] movies = {theGodfather, easyRider, eR, bodyHeat};
            for (Movie movie : movies) {
                System.out.println(movie);
                System.out.println();
            }
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void testEquals() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        try {
            RoadMovie easyRider = new RoadMovie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12), Vehicle.BIKE);
            
            System.out.println(easyRider.equals(new RoadMovie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12))));
            System.out.println(easyRider.equals(new Movie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12))));
            System.out.println(easyRider.equals(new Movie("Easy Rider", 1967, dHopper, easyRiderCast, new GregorianCalendar(1969, 6, 12))));
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void testAbstractClasses() {
//        PerformingArtist pa = new PerformingArtist();         // No! Cannot instantiate abstract class!
        PerformingArtist performingArtist = new PerformingArtist(PerformingArt.ACTING) {
            @Override
            public void showArt() {
                // TODO Auto-generated method stub
                System.out.println("Art: " + "a demo implementation");
            }
        };
        performingArtist.showArt();
        
        PerformingArtist alPacino = new Actor("Al Pacino", Sex.MALE, 79, Nationality.USA, PerformingArt.ACTING);
        alPacino.showArt();
    }
    
    public void testInterfaces() {
//        CrewMember alPacino = new Actor("Al Pacino", Sex.MALE, 79, Nationality.USA, PerformingArt.ACTING);
//        System.out.println(alPacino);
//        alPacino.showRole();
//        if (alPacino.isCoreMember()) {
//            System.out.println("\t(core member)");
//        }
//        CrewMember dHopper = new Director("Dennis Hopper", false, Nationality.USA);
//        System.out.println(dHopper);
//        dHopper.showRole();
//        if (dHopper.isCoreMember()) {
//            System.out.println("\t(core member)");
//        }
//        System.out.println();
        
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(dennisHopper);
        actors.add(peterFonda);
        actors.add(jackNicholson);
        System.out.println(actors);
        
        for (Actor actor : actors) {
            actors.remove(actor);                       // DANGEROUS! ConcurrentModificationException!
        }
     }
    
    public void testIterators() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(dennisHopper);
        actors.add(peterFonda);
        actors.add(jackNicholson);
        System.out.println(actors);
        
        Iterator<Actor> i = actors.iterator();
        while (i.hasNext()) {
            i.next();
//            i.remove();
        }
        System.out.println(actors);
        System.out.println(i.hasNext());
    }
    
    public void testExceptions() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);
        RoadMovie easyRider = null;
        try {
            easyRider = new RoadMovie("Easy Rider", 1969, dHopper, easyRiderCast, new GregorianCalendar(1968, 6, 12), Vehicle.BIKE);
        } catch (MovieYearException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println(easyRider);
        }
    }
    
    public void testTextFiles() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Actor[] actors = {dennisHopper, peterFonda, jackNicholson};
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(new File("actors.txt"))));
            for (Actor actor : actors) {
                out.println(actor.getName());
                out.println(actor.getAge());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        
        BufferedReader in = null;
        Actor[] a = new Actor[actors.length];
        try {
            in = new BufferedReader(new FileReader(new File("actors.txt")));
            for (int i = 0; i < a.length; i++) {
                a[i] = new Actor();
                a[i].setName(in.readLine());
                a[i].setAge(Integer.parseInt(in.readLine()));
                a[i].setNationality(Nationality.USA);
                a[i].setSex(Sex.MALE);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Actor actor : a) {
            System.out.println(actor);
        }
        
        System.out.print("Enter something: ");
        in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("You entered: " + in.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void testSerialization() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Cast easyRiderCast = new Cast();
        easyRiderCast.addActor(dennisHopper);
        easyRiderCast.addActor(peterFonda);
        easyRiderCast.addActor(jackNicholson);

        Movie easyRider = new Movie("Easy Rider", 1969, dHopper, actors1);
        easyRider.serialize("easyRider.serialized");
        System.out.println("Serialized.");
    }
    
    public void testDeserialization() {
//        Movie m = Movie.deserialize("easyRider.serialized");
//        System.out.println("Deserialized.");
//        System.out.println(m.getTitle());
//        System.out.println(m.getDirector());
//        for (Actor actor : m.getActors()) {
//            System.out.println(actor);
//        }
//        System.out.println(m.getOpeningDate().getTime());
        System.out.println(Movie.deserialize("easyRider.serialized"));
    }
    
    public void testProjectDirs() {
        System.out.println(Utility.getProjectDir());
        System.out.println(Utility.makeProjectSubdir("d1\\d2\\"));
        System.out.println(Utility.getResourcesDir());
    }
    
}
