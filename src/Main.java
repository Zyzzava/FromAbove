import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        // Prompt for grid size using JOptionPane
        String input = JOptionPane.showInputDialog("Enter grid size (rows x cols):");
        String[] dimensions = input.split("x");
        // Get the rows and cols
        int rows = Integer.parseInt(dimensions[0].trim());
        int cols = Integer.parseInt(dimensions[1].trim());
        int cellSize = 5; // Adjust this to change the cell size

        // Initiate the frame
        JFrame frame = new JFrame("FromAbove");
        Grid grid = new Grid(rows, cols, cellSize);

        JPanel contentPane = new JPanel(new BorderLayout());
        frame.setContentPane(contentPane);

        // Panel for top, which will display generation..
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(400, 50));
        contentPane.add(topPanel, BorderLayout.NORTH);

        // TODO FIND A WAY TO COUNT THIS
        int count = 0;
        JLabel generationLabel = new JLabel("Generation: " + count); // Initial generation count
        generationLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font size and style
        topPanel.add(generationLabel);

        contentPane.add(grid, BorderLayout.CENTER);

        // Testing
        Organism conor1 = new Organism(1, 1, Color.WHITE);
        conor1.setColor(Color.BLACK);
        grid.setOrganism(conor1);

        Organism conor2 = new Organism(1, 128, Color.WHITE);
        conor2.setColor(Color.BLACK);
        grid.setOrganism(conor2);

        Organism conor3 = new Organism(128, 1, Color.WHITE);
        conor3.setColor(Color.BLACK);
        grid.setOrganism(conor3);

        Organism conor4 = new Organism(128, 128, Color.WHITE);
        conor4.setColor(Color.BLACK);
        grid.setOrganism(conor4);

        grid.moveOrganismRight(conor1);

        grid.moveOrganismDown(conor2);

        grid.moveOrganismUp(conor3);

        grid.moveOrganismLeft(conor4);

        // Testing

        /*
         * TODO - Here should be used some createOrganisms() method
         * then set the positions for each of those organism in the grid.
         * using the setOrganism(x, y, organism)..
         */

        frame.setSize(400, 500); // Adjust the size of the frame here.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Call repaint to ensure that the grid is initially painted
        grid.repaint();
    }
}
