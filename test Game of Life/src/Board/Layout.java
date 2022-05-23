package Board;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout extends JFrame//  implements DocumentListener
{
    //this class creates the board of live and dead cells that change in state when the user manipulates the
    //option buttons board.
    public int row;
    public int col;
    public double _prob;
    public ButtonColors b = new ButtonColors();
    public String theme;
    public boolean [][] lightArr;
    public JButton[][] button;
    public JButton getButton (int r, int c){
        return button[r][c];
    }
    public int gameCnt = 0;

    //creates a panel that initializes an array of buttons and sets their
    //color–indicating whether they are alive or not– based on user input
    //that is taken through the methods executed by the overseer
    public Layout (int _askR, int _askC, String _theme, double probability){
        row = _askR;
        col = _askC;
        _prob = probability;
        theme = _theme;
        button = new JButton[row][col];
        lightArr = new boolean [row][col];

        JPanel panel = new JPanel(new GridLayout(row, col));
        panel.setSize(650,650);
        getContentPane().add(panel, BorderLayout.WEST);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                button[i][j] = new JButton();
                JButton b = button[i][j];
                makeButton(button[i][j], i, j);
                panel.add(button[i][j]);
            }
        }
        gameCnt++;

        this.setTitle("Tree Simulation");
        getContentPane().setLayout(new BorderLayout());
        this.setSize(650, 680);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    //helper method that updates a boolean array to true or false depending
    //on the state of the light. this array is used to identify the state change the cells
    //will undergo according to Conway's Game of Life rules
    public void makeButton ( JButton b, int r, int c){
        if (getChance()){
            setButtonOn(b,r,c);
        }
        else {
            setButtonOff(b,r,c);
       }
    }

    //sets button "on" by updating boolean array, setting the color and border setting
    public void setButtonOn (JButton ba, int ra, int ca){
        ba.setOpaque(true);
        ba.setBorderPainted(false);
        b.setButtonColor(theme, ba);
        lightArr[ra][ca] = true;
    }

    //sets button "off" by updating boolean array, setting the color and border setting
    public void setButtonOff (JButton ba, int ra, int ca){
        ba.setOpaque(true);
        ba.setBorderPainted(false);
        ba.setBackground(new java.awt.Color(0, 0, 0));
        lightArr[ra][ca] = false;
    }

    //helper method that returns true with a 40% chance
    public boolean getChance (){
        return Math.random() < _prob;
    }



}
