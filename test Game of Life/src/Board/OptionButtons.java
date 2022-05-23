package Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class OptionButtons extends JFrame implements ActionListener {

    private Layout _lay;
    private JButton[] options = new JButton[3];
    public int generationCNT = 0;
    public Layout getLay;
    private String[] text = {"nextGen", "freeze", "statistics"};

    //creates toggle board with a "nextGen", "freeze", and "statistics" button. nextGen
    //refreshes the cell board with the next generation of cells according to conway's game.
    //freeze duplicates the current board and serves as a "screenshot" function. statistics
    //displays the number of live/dead trees, and the average number of live to dead.
    public OptionButtons(Layout l) {
        _lay = l;
        getLay = l;
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setSize(200, 800);
        getContentPane().add(panel, BorderLayout.EAST);
        for (int i = 0; i < 3; i++) {
            options[i] = new JButton();
            JButton b = options[i];
            b.setText(text[i]);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == options[0]) {
                        boolean[][] aux = new boolean[_lay.row][_lay.col];
                        int cnt = 0;
                        for (int r = 0; r < _lay.row; r++) {
                            for (int c = 0; c < _lay.col; c++) {
                                if (r != 0) {
                                    if (c != 0 && _lay.lightArr[r - 1][c - 1]) {
                                        cnt++;
                                    }
                                    if (_lay.lightArr[r - 1][c]) {
                                        cnt++;
                                    }
                                    if (c != _lay.lightArr[r].length - 1 && _lay.lightArr[r - 1][c + 1]) {
                                        cnt++;
                                    }
                                }
                                if (c != 0) {
                                    if (_lay.lightArr[r][c - 1]) {
                                        cnt++;
                                    }
                                    if (r != _lay.lightArr.length - 1 && _lay.lightArr[r + 1][c - 1]) {
                                        cnt++;
                                    }
                                }
                                if (r != _lay.lightArr.length - 1) {
                                    if (_lay.lightArr[r + 1][c]) {
                                        cnt++;
                                    }
                                    if (c != _lay.lightArr[r].length - 1 && _lay.lightArr[r + 1][c + 1]) {
                                        cnt++;
                                    }

                                }
                                if (c != _lay.lightArr[r].length - 1 && _lay.lightArr[r][c + 1]) {
                                    cnt++;
                                }
                                if (cnt < 2 || cnt > 3) {
                                    aux[r][c] = false;
                                }
                                else if (_lay.lightArr[r][c] && (cnt == 3 || cnt == 2) ) {
                                    aux[r][c] = true;
                                }
                                else if (!_lay.lightArr[r][c] && cnt == 3) {
                                    aux[r][c] = true;
                                }
                                cnt = 0;
                            }
                        }
                        for(int row = 0; row < _lay.row; row++){
                            for(int col = 0; col < _lay.col; col++){
                                if(aux[row][col])
                                    _lay.setButtonOn(_lay.button[row][col], row, col);
                                else
                                    _lay.setButtonOff(_lay.button[row][col], row, col);
                            }
                        }
                    } else if (e.getSource() == options[1]) {
                        FreezeButton fr = new FreezeButton(l);
                    } else if (e.getSource() == options[2]) {
                        JOptionPane.showMessageDialog(panel, "Number of live trees: " + treeCount() +
                                "\nNumber of dead trees " + deadtreeCount() +
                                "\nPercent live trees: " + avg() + "%");
                    }
                }
            });
            panel.add(options[i]);
        }

        this.setTitle("Simulation Operators");
        getContentPane().setLayout(new BorderLayout());
        this.setSize(200, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    //helper method that retrieves number of live trees
    private int treeCount() {
        int treeCNT = 0;
        for (int i = 0; i < _lay.row; i++) {
            for (int j = 0; j < _lay.col; j++) {
                if (_lay.lightArr[i][j]) {
                    treeCNT++;
                }
            }
        }
        return treeCNT;
    }

    //helper method that returns average of live to dead trees
    private float avg() {
        float total = treeCount() + deadtreeCount();
        float num = treeCount();
        return num * 100 / total;
    }
    //helper method that returns number of dead trees
    private int deadtreeCount() {
        int treeCNT = 0;
        for (int i = 0; i < _lay.row; i++) {
            for (int j = 0; j < _lay.col; j++) {
                if (!_lay.lightArr[i][j]) {
                    treeCNT++;
                }
            }
        }
        return treeCNT;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}

