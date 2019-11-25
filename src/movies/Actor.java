/*
 * Created on Oct 6, 2019
 *
 */
package movies;

import java.io.Serializable;

import util.Nationality;
import util.Sex;

public class Actor extends PerformingArtist implements CrewMember, Serializable {
    
    private static String definition;
    
    private String name;
    private Sex sex;
    private int age;
    private Nationality nationality;
    
    public Actor(String name, Sex sex, int age, Nationality nationality, PerformingArt performingArt) {
        this(name, sex, age, nationality);
        this.performingArt = performingArt;
    }

    static {
        definition = "A person who portrays a character in a performance.";
    }
    
    public Actor(String name, Sex sex, int age, Nationality nationality) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Actor() {
        super();
    }
    
    public static String describe() {
        return definition;
    }
    
    @Override
    public void showArt() {
        System.out.println("Art: " + this.performingArt);
    }

    @Override
    public void showRole() {
        System.out.println("\t" + (this.sex == Sex.FEMALE ? "actress" : "actor"));
    }

    @Override
    public boolean isCoreMember() {
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Actor:" +
                "\n\tname: " + this.name +
                "\n\tsex: " + this.sex +
                "\n\tage: " + ((this.age != -1) ? this.age : "deceased") +
                "\n\tnationality: " + this.nationality;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Nationality getNationality() {
        return nationality;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public static String getDefinition() {
        return definition;
    }

    public static void setDefinition(String definition) {
        Actor.definition = definition;
    }

}
