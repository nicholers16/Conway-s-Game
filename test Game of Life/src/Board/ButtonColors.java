package Board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ButtonColors {
    //this is a storage class that contains specific RGB values generated by an online program and
    //their color values.

    //stores an array of "tropical" colors that are randomly selected to create a game with tropical colored cells
    public Color[] tropColor = {Color.decode("#8FA01F"), Color.decode("#1D741B"), Color.decode("#8BCD50"),
            Color.decode("#2E4007"),Color.decode("#F831B0"),Color.decode("#FECE20"), Color.decode("#929650"),
            Color.decode("#ED8660")};
    //stores an array of "temperate" colors that are randomly selected to create a game with temperate colored cells
    public Color[] tempColor = {Color.decode("#B3C1A8"), Color.decode("#E3CCDE"), Color.decode("#2B5434"),
            Color.decode("#2E4007"),Color.decode("#D2FBA4"),Color.decode("#F1C0B9"), Color.decode("#88CA5E"),
            Color.decode("#1D741B")};
    //stores an array of "savannah" colors that are randomly selected to create a game with savannah colored cells
    public Color[] savColor = {Color.decode("#B7AC44"), Color.decode("#DF362D"), Color.decode("#FF8300"),
            Color.decode("#FF4500"),Color.decode("#F6A21E"),Color.decode("#104210"), Color.decode("#104210"),
            Color.decode("#7A871E")};

    //empty constructor since the class is only used to access the methods
    public ButtonColors(){

    }

    //uses user input that is passed in as a parameter (theme variable in Overseer) to set a button color
    public void setButtonColor (String _theme, JButton button){
        if (_theme.equalsIgnoreCase("savannah")){
            Random randomNum = new Random();
            int x = randomNum.nextInt(savColor.length);
            button.setBackground(savColor[x]);
        }
        else if (_theme.equalsIgnoreCase("tropical")){
            Random randomNum = new Random();
            int x = randomNum.nextInt(tropColor.length);
            button.setBackground(tropColor[x]);
        }
        else if (_theme.equalsIgnoreCase("temperate")){
            Random randomNum = new Random();
            int x = randomNum.nextInt(tempColor.length);
            button.setBackground(tempColor[x]);
        }
    }



}