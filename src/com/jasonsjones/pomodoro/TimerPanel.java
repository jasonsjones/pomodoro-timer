package com.jasonsjones.pomodoro;

import javax.swing.BorderFactory;

public class TimerPanel extends TimeDisplayPanel {

    public TimerPanel() {
        super();
        setUpUI();
    }

    protected void setUpUI() {
        super.setUpUI();
        this.setBorder(BorderFactory.createTitledBorder("Timer"));
    }
}
