import java.awt.Graphics;

import javax.swing.JComponent;

public class Grid extends JComponent {
    private int rows;
    private int cols;
    private int cellSize;
    private Cell[][] cells;
    
    /*
     * Constructor for creating new Grid objects, based on number of rows and cols.
     * And the cellSize.
     */
    public Grid(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.cells = new Cell[rows][cols];
        // Initialize all cells with no organisms
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /*
     * Method which is going to be setting an organism on a specific coordinate,
     * given an organism.
     */
    public void setOrganism(Organism organism) {
        cells[organism.getX() - 1][organism.getY() - 1].setOrganism(organism);
        // Subtract 1, we index
        // by 0, but give
        // coordinates in index
        // by 1.
    }

    /*
     * Method paint overriding the already existing, it's here that the code for
     * drawing the grid goes.
     */
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        int availableWidth = getWidth();
        int availableHeight = getHeight();
        // Calculate new cell size to fit the space
        int newCellSize = Math.min(availableWidth / cols, availableHeight / rows);
        // Update cell size
        cellSize = newCellSize;
        // Draw grid lines
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize);
        }
        for (int i = 0; i <= cols; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize);
        }
        // Fill cells with organism colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Organism organism = cells[i][j].getOrganism();
                if (organism != null) {
                    g.setColor(organism.getColor());
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    // ORGANISM MOVEMENT
    /*
     * Move organism right.
     */
    public void moveOrganismRight(Organism org) {
        if (org.getX() < cols) {
            org.moveRight();
            setOrganism(org);
        }
    }

    /*
     * Move organism left.
     */
    public void moveOrganismLeft(Organism org) {
        if (0 < org.getY() - 1) {
            org.moveLeft();
            setOrganism(org);
        }
    }

    /*
     * Move organism up.
     */
    public void moveOrganismUp(Organism org) {
        if (0 < org.getX() - 1) {
            org.moveUp();
            setOrganism(org);
        }
    }

    /*
     * Move organism down;
     */
    public void moveOrganismDown(Organism org) {
        if (org.getX() + 1 < rows) {
            org.moveDown();
            setOrganism(org);
        }
    }
}
