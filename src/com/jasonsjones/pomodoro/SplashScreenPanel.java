package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;

public class SplashScreenPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    public SplashScreenPanel() {
        setUpUI();
    }

    private void setUpUI() {
        JLabel label = new JLabel();
        label.setFont(new Font("Helvetica", Font.BOLD, 32));
        label.setText("Pomodoro Timer");

        JLabel directions = new JLabel();
        directions.setFont(new Font("Helvetica", Font.PLAIN, 16));
        directions.setText("Select desired 'Mode' from the menu");

        JLabel copyright = new JLabel();
        copyright.setFont(new Font("Helvetica", Font.ITALIC, 12));
        copyright.setText("copyright 2015 Jason Jones");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;

        gc.weighty = 0.5;
        this.add(label, gc);

        gc.weighty = 0.0;
        gc.gridy++;
        this.add(directions, gc);

        gc.weighty = 0.8;
        gc.gridy++;
        this.add(copyright, gc);

        this.setVisible(true);
    }
}
