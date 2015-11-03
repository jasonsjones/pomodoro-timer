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

        JMenu view = new JMenu("View");

        JMenuItem splashMenuItem = new JMenuItem("Splash Screen");
        splashMenuItem.addActionListener(this);

        JMenuItem timerMenuItem = new JMenuItem("Timer");
        timerMenuItem.addActionListener(this);

        JMenuItem stopWatchMenuItem = new JMenuItem("StopWatch");
        stopWatchMenuItem.addActionListener(this);

        view.add(splashMenuItem);
        view.add(timerMenuItem);
        view.add(stopWatchMenuItem);
        this.add(view);
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
