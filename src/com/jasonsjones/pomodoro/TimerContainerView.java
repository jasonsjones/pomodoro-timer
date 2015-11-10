package com.jasonsjones.pomodoro;

import javax.swing.*;
import java.awt.*;

public class TimerContainerView extends ContainerView {

    AdjustTimerButtonPanel adjustTimerButtonPanel;

    public TimerContainerView() {
        super(new TimerPanel());
        adjustTimerButtonPanel = new AdjustTimerButtonPanel();
        this.add(adjustTimerButtonPanel, BorderLayout.WEST);
    }

    public AdjustTimerButtonPanel getAdjustTimerButtonPanel() {
        return this.adjustTimerButtonPanel;
    }
}
