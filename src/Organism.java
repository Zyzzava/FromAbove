import java.awt.Color;

public class Organism {
    // Stuff goes here...
    private int[] coordinate = new int[2];
    private Color color;

    /*
     * Constructor, for creating organisms.
     */
    public Organism(int xcoord, int ycoord, Color color) {
        // Assign x and y-coordinates. Only positive values.
        if (0 < xcoord && 0 < ycoord) {
            this.coordinate[0] = xcoord;
            this.coordinate[1] = ycoord;
        }
        // Assign the color of the organism.
        this.color = color;
    }

    /*
     * Get the Organism coordinates.
     */
    public int[] getCoordinate() {
        return coordinate;
    }

    /*
     * Get the Organism x-coordinate.
     */
    public int getX() {
        return coordinate[0];
    }

    /*
     * Get the Organism y-coordinate.
     */
    public int getY() {
        return coordinate[1];
    }

    /*
     * Get the Organism y-coordinate.
     */

    /*
     * Returns the color of the organism.
     */
    public Color getColor() {
        // change this, such that it's determined by genes
        return color;
    }

    /*
     * Sets the color of the organism.
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    // MOVEMENT
    /*
     * Move right.
     */
    public void moveRight() {
        coordinate[1]++;
    }

    /*
     * Move left.
     */
    public void moveLeft() {
        coordinate[1]--;
    }

    /*
     * Move up.
     */
    public void moveUp() {
        coordinate[0]--;
    }

    /*
     * Move down;
     */
    public void moveDown() {
        coordinate[0]++;
    }
}
