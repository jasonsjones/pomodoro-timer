package com.jasonsjones.pomodoro;

import javax.swing.BorderFactory;

public class StopWatchPanel extends TimeDisplayPanel {

    public StopWatchPanel() {
        super();
        setUpUI();
    }

    protected void setUpUI() {
        super.setUpUI();
        this.setBorder(BorderFactory.createTitledBorder("StopWatch"));
    }
}
