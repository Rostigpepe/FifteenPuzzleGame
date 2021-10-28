package fifteenpuzzle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameAndFunctions extends MainGameWindow {

    public GameAndFunctions(int gridSize) {
        super(gridSize);
    }


    /**The swapping function we use to make the game itself actually be interactive
     * @param clickedButton The button clicked in game
     *                      It is used, so we know what button to swap out with empty
     */
    public static void swap(JButton clickedButton){
        puzzlePanel.add(clickedButton, allButtons.indexOf(emptySpace));
        puzzlePanel.add(emptySpace, allButtons.indexOf(clickedButton));
        puzzlePanel.revalidate();
        Collections.swap(allButtons, allButtons.indexOf(emptySpace), allButtons.indexOf(clickedButton));

        //If the first index == 1, and the last index before where empty is supposed to be == Area - 1
        //Then we'll start checking win condition
        int indexFirst = Integer.parseInt(MainGameWindow.allButtons.get(0).getText());
        int indexLast = Integer.parseInt(MainGameWindow.allButtons.get(allButtons.size() - 2).getText());
        int lastSupposedNumber = MainGameWindow.allButtons.size() - 1;

        if(indexFirst == 1 && indexLast == lastSupposedNumber){
            boolean gameWon = checkWinCondition(MainGameWindow.allButtons);

            if(gameWon){
                gameWon();
            }
        }
    }


    /**Function that checks the arraylist of buttons to validate if it is correct
     * It checks if it goes from 1 -> size of the list, but double checks that the last index is the empty button
     * @param list list of all the buttons
     * @return whether the game is won
     */
    public static boolean checkWinCondition(ArrayList<JButton> list){
        for (int i = 0; i < list.size(); i++) {
            int tempNum = Integer.parseInt(list.get(i).getText());

            if(tempNum != i + 1 && i != list.size() - 1){
                break;
            }
            else if(tempNum == 0 && i == list.size() - 1){
                return true;
            }
        }
        return false;
    }


    /**
     * Literally just a method that runs if the game has been won
     */
    public static void gameWon(){
        JOptionPane.showMessageDialog(null,"Congratulaaaaatioooons! You Won!");
        startUpOptions();
    }


    public static void startUpOptions(){
        boolean open = true;
        String size = JOptionPane.showInputDialog("Choose size of the game");

        while(open){
            try{
                int gameSize = Integer.parseInt(size);

                //Block of code to refresh the whole game
                //Removes the panel where the game is located, recreates it all and restarts
                MainGameWindow.puzzlePanel.removeAll();
                MainGameWindow.allButtons.clear();
                new GameAndFunctions(gameSize);
                MainGameWindow.gameFrame.revalidate();

                open = false;
            }
            catch(NumberFormatException ignored){
                size = JOptionPane.showInputDialog("Only enter a number");
            }
        }
    }
}

