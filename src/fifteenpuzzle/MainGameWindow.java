package fifteenpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainGameWindow extends JFrame {
    private int gridSize = 4;
    Random rSeed = new Random();

    public MainGameWindow(){
        JPanel puzzlePanel = new JPanel();
        puzzlePanel.setLayout(new GridLayout(gridSize, gridSize));

        int count = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                if(count == 16){
                    count = 0;
                    JButton button = new JButton("");
                    puzzlePanel.add(button);
                    break;
                }

                JButton button = new JButton("" + count);
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
