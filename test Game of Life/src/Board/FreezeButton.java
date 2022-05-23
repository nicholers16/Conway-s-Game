package Board;

import javax.swing.*;
import java.awt.*;

public class FreezeButton extends JFrame {

    //this class creates a button that duplicates a specific instance of the cell board, like a screenshot, when initialized
    private int row;
    private int col;

    //uses layout passed as a parameter to create a new panel with the layout's contents, creating an identical set of live/dead cells
    public FreezeButton(Layout _l) {
        row = _l.row;
        col = _l.col;
        JPanel p = new JPanel(new GridLayout(row, col));
        p.setSize(650, 680);
        getContentPane().add(p, BorderLayout.NORTH);
        JButton[][] _frButton = new JButton[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                _frButton[i][j] = _l.getButton(i, j);
                p.add(_frButton[i][j]);
            }
        }
        this.setTitle("Tree Simulation");
        getContentPane().setLayout(new BorderLayout());
        this.setSize(650, 680); // Size of the chess board
        this.setVisible(true); // Sets the board visible
        this.setResizable(true); //The window is not resizable anymore ;)
    }
}
