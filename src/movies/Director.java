/*
 * Created on Sep 29, 2019
 *
 */
package movies;

import util.Nationality;

public class Director implements CrewMember {
    
    private String name;
    private boolean alive;
    private Nationality nationality;
    
    public Director(String name, boolean alive, Nationality nationality) {
        super();
        this.name = name;
        this.alive = alive;
        this.nationality = nationality;
    }
    
    public void signalShooting(String signal) {
        System.out.println(signal);
    }
    
    @Override
    public void showRole() {
        System.out.println("\trole: director");
    }

    @Override
    public boolean isCoreMember() {
        return true;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Director" + "\n\t" +
                    "name: " + this.name + "\n\t" +
                    "nationality: " + this.nationality + "\n\t" +
                    "alive: " + (this.alive ? "yes" : "no");
    }
    
    public Director() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

}
