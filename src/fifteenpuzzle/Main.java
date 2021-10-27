package fifteenpuzzle;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean open = true;
        String size = JOptionPane.showInputDialog("Choose size of the game");

        while(open){
            try{
                int gameSize = Integer.parseInt(size);
                new GameAndFunctions(gameSize);
                open = false;
            }
            catch(NumberFormatException ignored){
                size = JOptionPane.showInputDialog("Only enter a number");
            }
        }
    }
}
