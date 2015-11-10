package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjustTimerButtonPanel extends JPanel implements ActionListener {

    private ClickListener clickListener;

    public AdjustTimerButtonPanel() {
        JButton incrementMinuteBtn = new JButton("+ min");
        incrementMinuteBtn.addActionListener(this);

        JButton decrementMinuteBtn = new JButton("- min");
        decrementMinuteBtn.addActionListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 0.3;
        gc.fill = GridBagConstraints.NONE;
        this.add(incrementMinuteBtn, gc);
        gc.gridy++;
        this.add(decrementMinuteBtn, gc);
    }

    public void addClickListener(ClickListener listener) {
        this.clickListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (clickListener != null) {
            clickListener.onClick(e);
        }
    }
}
