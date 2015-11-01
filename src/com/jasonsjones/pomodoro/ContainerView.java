package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;

public class ContainerView extends JPanel {

    protected TimeDisplayPanel displayPanel;
    protected ButtonPanel buttonPanel;

    public ContainerView(TimeDisplayPanel tdp) {
        buttonPanel = new ButtonPanel();
        this.setDisplayPanel(tdp);
        this.setLayout(new BorderLayout());

        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public ButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }

    public TimeDisplayPanel getDisplayPanel() {
        return this.displayPanel;
    }

    public JLabel getDisplayPanelLabel() {
        return this.displayPanel.getLabel();
    }

    public void setDisplayPanel(TimeDisplayPanel tdp) {
        this.displayPanel = tdp;
    }
}
