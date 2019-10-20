/*
 * Created on Oct 19, 2019
 *
 */
package movies;

import java.util.ArrayList;

public class Cast {
    
    private ArrayList<Actor> actors;
    private String location;
    
    public Cast(ArrayList<Actor> actors, String location) {
        super();
        this.actors = actors;
        this.location = location;
    }
    
    public Cast() {
        super();
        this.actors = new ArrayList<Actor>();
    }
    
    public boolean addActor(Actor actor) {
        // Possible direct implementation
//        if (!this.actors.contains(actor)) { 
//            this.actors.add(actor);
//            return true;
//        } else {
//            return false;
//        }
        return this.actors.add(actor);
    }
    
    public boolean removeActor(Actor actor) {
        return this.actors.remove(actor);
    }
    
    public Actor[] toArray() {
        return this.actors.toArray(new Actor[this.actors.size()]);
    }
    
    public ArrayList<Actor> getActors() {
        return actors;
    }
    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
