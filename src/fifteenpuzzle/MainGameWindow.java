package fifteenpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGameWindow extends JFrame {


    /**Method for the main game window itself, with all its buttons
     * @param gridSize Desired game size, the game size = gridSize^2
     */
    public MainGameWindow(int gridSize){

        //With this method we generate numbers and get them in a random sequence, with no duplicates
        ArrayList<Integer> randomNums = UniqueRandomNumbers.generateUniqueRandomNumbers(gridSize * gridSize);

        JPanel puzzlePanel = new JPanel();
        puzzlePanel.setLayout(new GridLayout(gridSize, gridSize));

        //Variable to replace standard i since we're using nested for i loops
        int count = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                //Taking the number at a specific spot in the list and assigning that to tempNum
                int tempNum = randomNums.get(count);
                //If the tempNum is 0, we want that button to be empty
                if(tempNum == 0){
                    JButton button = new JButton("");
                    puzzlePanel.add(button);
                    count++;
                    continue;
                }

                //If tempNum is anything other than 0, we'll make the button named that
                JButton button = new JButton("" + randomNums.get(count));
                count++;
                puzzlePanel.add(button);
            }
        }


        setContentPane(puzzlePanel);
        setPreferredSize(new Dimension(400,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
