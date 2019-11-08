/*
 * Created on Nov 8, 2019
 *
 */
package movies;

public interface CrewMember {
    
    public void showRole();
    public boolean isCoreMember();
    
    default public void showCrewSize() {
        System.out.println("(crew size unknown)");
    }

}
