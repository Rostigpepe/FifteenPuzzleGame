package fifteenpuzzle;

import javax.swing.*;

public class GameMenu extends JPanel{
    JMenuBar menuBar = new JMenuBar();

    public GameMenu (){

        JMenu game = new JMenu("Options");
        game.setVisible(true);
        menuBar.add(game);


        JMenuItem changeSize = new JMenuItem("Reset");
        game.add(changeSize);
        changeSize.addActionListener(e -> {
            String size = JOptionPane.showInputDialog("New board size");
            int newSize = Integer.parseInt(size);

            MainGameWindow.puzzlePanel.removeAll();
            MainGameWindow.allButtons.clear();
            new GameAndFunctions(newSize);
            revalidate();
        });


        JMenuItem exit = new JMenuItem("Exit");
        game.add(exit);
        exit.addActionListener(e -> System.exit(0));
    }

}