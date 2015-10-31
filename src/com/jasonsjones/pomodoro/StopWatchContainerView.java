package com.jasonsjones.pomodoro;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

public class StopWatchContainerView extends JPanel{

    private ButtonPanel buttonPanel;
    private StopWatchPanel stopWatchPanel;

    public StopWatchContainerView() {
        buttonPanel = new ButtonPanel();
        stopWatchPanel = new StopWatchPanel();
        this.setLayout(new BorderLayout());

        this.add(stopWatchPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public ButtonPanel getStopWatchButtonPanel() {
        return this.buttonPanel;
    }

    public StopWatchPanel getStopWatchPanel() {
        return this.stopWatchPanel;
    }

    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchPanel.getLabel();
    }
}
