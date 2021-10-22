package fifteenpuzzle;

import javax.swing.*;
import java.awt.*;

public class MainGameWindow extends JFrame {
    public MainGameWindow(){
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(400,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
