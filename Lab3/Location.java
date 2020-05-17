public class Location {

    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public int HashCode() {
     return 256 * (256* 8 + this.xCoord) + this.yCoord;
    }

    public boolean equals (Object object){
        if (object instanceof Location) {
            return ((Location) object).xCoord == this.xCoord && ((Location) object).yCoord == this.yCoord;
        } else {
            return false;
        }
    }
}
