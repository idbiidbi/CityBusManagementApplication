package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    JPanel mainPanel;

    public MainForm() {
        this.setTitle("BUs stop");
        //this.setSize(500, 500);
        this.setSize(new Dimension(2000, 2000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void showForm() {
        createUi();
        this.setVisible(true);
    }

    private void createUi() {
        mainPanel = new JPanel();

        mainPanel.add(new JLabel("Hello"));
        JButton ok = new JButton("OK");
        mainPanel.add(ok);

        this.setContentPane(mainPanel);
    }
}
