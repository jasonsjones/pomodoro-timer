package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;

public class TimeDisplayPanel extends JPanel {

    protected static final long serialVersionUID = 1L;

    JLabel label;

    public TimeDisplayPanel() {
        label = new JLabel();
    }

    public JLabel getLabel() {
        return label;
    }

    protected void setUpUI() {
        label.setFont(new Font("Helvetica", Font.BOLD, 42));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        this.add(label, gc);

        this.setVisible(true);
    }
}
