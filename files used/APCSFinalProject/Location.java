/**
 * 
 *  Is Location with x and y coordinates.
 *  Contains methods such as getX, getY, and equals.
 *
 *  @author  Ajeet, Matthew
 *  @version May 28, 2019
 *  @author  Period: 4th
 *  @author  Assignment: APCSFinalProject
 *
 *  @author  Sources: None
 */
public class Location
{
    private int coorX;
    private int coorY;
    
    /**
     * Creates Location object
     * @param x - x-coordinate of the Location
     * @param y - y-coordinate of the Location
     */
    public Location(int x, int y) {
        coorX = x;
        coorY = y;
    }
    
    /**
     * 
     * Returns x-coordinate of location.
     * @return x-coordinate of location.
     */
    public int getX()
    {
        return coorX;
    }
    
    /**
     * 
     * Returns y-coordinate of location.
     * @return y-coordinate of location.
     */
    public int getY()
    {
        return coorY;
    }
    
    /**
     * 
     * Determines whether locations are equal to each other.
     * @param l - location this location is being compared to.
     * @return whether locations are equal to each other.
     */
    public boolean equals(Location l)
    {
        if(this.getX() == l.getX() && this.getY() == l.getY())
        {
            return true;
        }
      return false;
    }
}