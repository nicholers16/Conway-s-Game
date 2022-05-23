package Board;

import javax.swing.*;
import java.awt.*;

public class Overseer {
    //this class runs the object that is initialized in the main method. it introduces the story, receives user input to
    //create the bounds of the game, and opens the actual cell block and toggle board.
    private Layout _lay;
    private String _theTheme;
    private OptionButtons _ob;
    private int _row;
    private int _col;
    public double _prob;

    //runs introduction message, asks user a question to initialize the theme, row, probability. Opens a layout
    //panel that contains the live/dead cells, and an option buttons panel that contains toggle buttons to use the program
    public Overseer (){
        introduction1();
        setTheme();
        askRow();
        askProb();
        JOptionPane.showMessageDialog(null, "Non-black squares are live cells.");
        _lay = new Layout (_row, _col, _theTheme, _prob);
        _ob = new OptionButtons(_lay);
    }

    //takes user input to initialize the value of the probability variable
    public void askProb (){
        _prob = Double.parseDouble(JOptionPane.showInputDialog("Set probability: \"0.1\" to \"0.8\" "));
        while (!(_prob >= 0.1 && _prob <=25)){
            JOptionPane.showMessageDialog(null,"out of bounds!");
            _prob = Double.parseDouble(JOptionPane.showInputDialog("Set probability: \"0.1\" to \"0.8\" "));
        }
    }

    //takes user input to initialize the value of the row variable, which is used to create a square board of cells
    public void askRow (){
        int _r = Integer.parseInt(JOptionPane.showInputDialog("Set square row/column size. Min is '10', max is '25'."));
        while (!(_r >= 10 && _r <=25)){
            JOptionPane.showMessageDialog(null,"out of bounds!");
            _r = Integer.parseInt(JOptionPane.showInputDialog("Set square row/column size. Min is '10', max is '25'."));
        }
        _row = _r;
        _col = _r;
    }

    //message introduction stating the rules and functionality of the game
    public static void introduction1() {
        JPanel panel = new JPanel();
        JLabel a = new JLabel("Hello biology professor Rico! Welcome to the Life Simulator.");
        JLabel b = new JLabel("This model simulates the number of trees in a forest.");
        JLabel c = new JLabel("The \"nextGen\" button simulates the next generation of forests.");
        JLabel d = new JLabel("The \"freeze\" button takes a snapshot of the current generation.");
        JLabel e = new JLabel("The \"freeze\" button will appear beneath the Tree Simulation panel.");
        JLabel f = new JLabel("The \"statistics\" button reports how many living trees there are.");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(a);
        panel.add(b);
        panel.add(c);
        panel.add(d);
        panel.add(e);
        panel.add(f);
        panel.setBackground(new Color(154, 205, 50));
        JOptionPane.showMessageDialog(null, panel, "Life Simulator", JOptionPane.INFORMATION_MESSAGE);
    }

    //sets the theme of the game
    public void setTheme (){
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        Object[] options = {"tropical", "temperate", "savannah"};
        Object selectionObject = JOptionPane.showInputDialog(frame, "Choose a biome", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        _theTheme = selectionObject.toString();
    }

}
