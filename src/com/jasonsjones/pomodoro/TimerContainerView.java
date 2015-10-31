package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;

public class TimerContainerView extends JPanel {

    private ButtonPanel buttonPanel;
    private TimerPanel timerPanel;

    public TimerContainerView() {
        buttonPanel = new ButtonPanel();
        timerPanel = new TimerPanel();
        this.setLayout(new BorderLayout());

        this.add(timerPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public ButtonPanel getTimerButtonPanel() {
        return this.buttonPanel;
    }

    public TimerPanel getTimerPanel() {
        return this.timerPanel;
    }

    public JLabel getTimerPanelLabel() {
        return this.timerPanel.getLabel();
    }
}
