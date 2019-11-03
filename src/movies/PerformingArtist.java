/*
 * Created on Nov 3, 2019
 *
 */
package movies;

public abstract class PerformingArtist {
    
    protected PerformingArt performingArt;

    public PerformingArtist(PerformingArt performingArt) {
        super();
        this.performingArt = performingArt;
    }
    
    public PerformingArtist() {
        super();
    }
    
    public abstract void showArt();

    public PerformingArt getPerformingArt() {
        return performingArt;
    }

    public void setPerformingArt(PerformingArt performingArt) {
        this.performingArt = performingArt;
    }
    
}
