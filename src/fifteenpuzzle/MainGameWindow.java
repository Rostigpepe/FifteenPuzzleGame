package fifteenpuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Method that creates the window where the game is played, used so we can extend JFrame and implement ActionListener
 */
public class MainGameWindow extends JFrame implements ActionListener {

    //All of these needs to be outside the MainGameWindow method so that we can access them in other places as well
    protected static JPanel puzzlePanel = new JPanel();
    protected static ArrayList<JButton> allButtons = new ArrayList<>();
    protected static JButton emptySpace = new JButton("");
    protected  int gridSize = 0;

    /**Method for the main game window itself, with all its buttons
     * @param gSize Desired game size, the game size = gridSize^2
     */
    protected MainGameWindow(int gSize){
        gridSize = gSize;

        //With this method we generate numbers and get them in a random sequence, with no duplicates
        ArrayList<Integer> randomNums = UniqueRandomNumbers.generateUniqueRandomNumbers(gridSize * gridSize);
        puzzlePanel.setLayout(new GridLayout(gridSize, gridSize));

        //Variable to replace standard i since we're using nested for i loops
        int count = 0;
        //Nested for loops to create all the required buttons for the game
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                //Taking the number at a specific spot in the list and assigning that to tempNum
                int tempNum = randomNums.get(count);

                //If the tempNum is 0, we want that button to be the empty space
                if(tempNum == 0){
                    //Action listener so that the button is actually interactive
                    emptySpace.addActionListener(this);

                    //Adding the button to the GUI and the list of all buttons
                    puzzlePanel.add(emptySpace);
                    allButtons.add(emptySpace);

                    //Setting the empty space to invisible
                    emptySpace.setVisible(false);
                    count++;
                    continue;
                }

                //If tempNum is anything other than 0, we'll make the button named that
                JButton button = new JButton("" + randomNums.get(count));
                button.addActionListener(this);
                puzzlePanel.add(button);
                allButtons.add(button);
                count++;
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(puzzlePanel);
        setPreferredSize(new Dimension(700,700));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }


    /**Method used to decide whether we should call swap or not
     * This depends on whether the clicked button is next to the empty space
     * @param e Event captured by actionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if ((allButtons.indexOf(clickedButton) + 1) == allButtons.indexOf(emptySpace)) {
            GameAndFunctions.swap(clickedButton);
        }
        else if ((allButtons.indexOf(clickedButton) - 1) == allButtons.indexOf(emptySpace)) {
            GameAndFunctions.swap(clickedButton);
        }
        else if ((allButtons.indexOf(clickedButton) + gridSize) == allButtons.indexOf(emptySpace)) {
            GameAndFunctions.swap(clickedButton);
        }
        else if ((allButtons.indexOf(clickedButton) - gridSize) == allButtons.indexOf(emptySpace)) {
            GameAndFunctions.swap(clickedButton);
        }
        else{
            System.out.println("Cringe");
        }
    }
}
