package com.jasonsjones.pomodoro;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends JMenuBar implements ActionListener {

    private MainMenuListener mainMenuListener;

    public MainMenuBar() {
        JMenu file = new JMenu("File");
        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.addActionListener(this);

        file.add(eMenuItem);
        this.add(file);

        JMenu mode = new JMenu("Mode");
        JMenuItem timerMenuItem = new JMenuItem("Timer");
        timerMenuItem.addActionListener(this);
        JMenuItem stopWatchMenuItem = new JMenuItem("StopWatch");
        stopWatchMenuItem.addActionListener(this);

        mode.add(timerMenuItem);
        mode.add(stopWatchMenuItem);
        this.add(mode);
    }

    public void addMainMenuListener(MainMenuListener listener) {
       this.mainMenuListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Exit"))
            System.exit(0);
        else {
            if (mainMenuListener != null) {
                mainMenuListener.emitMenuEvent(event);
            }
        }
    }
}
