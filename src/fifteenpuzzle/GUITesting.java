package fifteenpuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITesting implements ActionListener {

    private int count = 0;
    private JFrame jf;
    private JLabel jl;
    private JPanel jp;
    int test;
    int babab;

    GUITesting(){
        jf = new JFrame();
        JButton button = new JButton("Test button");
        button.addActionListener(this);

        jl = new JLabel("Clicks: 0");
        jp = new JPanel();

        jp.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
        jp.setLayout(new GridLayout(4, 4));
        jp.add(button);
        jp.add(jl);

        jf.add(jp, BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Test GUI");
        jf.pack();
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        jl.setText("Clicks: " + count);
    }
}
