import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MazeCreator extends JFrame {

    private static final int SIZE = 20; // Size of each cell in pixels
    private static final int ROWS = 20; // Number of rows
    private static final int COLS = 20; // Number of columns

    private Color[][] cellColors = new Color[ROWS][COLS]; // Store colors for each cell

    public MazeCreator() {
        setTitle("Maze Creator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(COLS * SIZE, ROWS * SIZE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(ROWS, COLS));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                final int row = i; // Capture the value of i
                final int col = j; // Capture the value of j
                JPanel cell = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(cellColors[row][col]); // Get color for this cell
                        g.fillRect(0, 0, SIZE, SIZE);
                        g.setColor(Color.BLACK);
                        g.drawRect(0, 0, SIZE, SIZE);
                    }
                };
                cell.setPreferredSize(new Dimension(SIZE, SIZE));
                cellColors[i][j] = Color.BLUE; // Set initial color to blue

                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            // Toggle color between blue and white
                            cellColors[row][col] = (cellColors[row][col] == Color.BLUE) ? Color.WHITE : Color.BLUE;
                            cell.repaint();
                        }
                    }
                });
                panel.add(cell);
            }
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MazeCreator::new);
    }
}
