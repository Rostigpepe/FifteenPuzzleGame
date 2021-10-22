package fifteenpuzzle;

import javax.swing.*;
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
    }
}
