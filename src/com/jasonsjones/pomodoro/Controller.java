package com.jasonsjones.pomodoro;

import java.awt.event.ActionEvent;

public class Controller {

    public static final int SPLASH_STATE = 0;
    public static final int STOPWATCH_STATE = 1;
    public static final int TIMER_STATE = 2;

    private volatile boolean running = true;

    private TimeModel model;
    private MainFrameView mainFrame;
    private int state;

    public Controller(TimeModel model, MainFrameView view) {
        this.model = model;
        this.mainFrame = view;
        setUpListeners();
        setDisplayState(SPLASH_STATE);
    }

    private void setUpListeners() {
        this.mainFrame.getStopWatchButtonPanel()
                .addClickListener(new ClickListener() {
                    @Override
                    public void onClick(ActionEvent e) {
                        if (e.getActionCommand().equals("Start")) {
                            stopWatchStart();
                        } else if (e.getActionCommand().equals("Stop")) {
                            stopWatchStop();
                        } else {
                            model.reset();
                            mainFrame.getStopWatchPanelLabel().setText(model.toString());
                        }
                    }
                });

        this.mainFrame.getMainMenuBar()
                .addMainMenuListener(new MainMenuListener() {
                    @Override
                    public void emitMenuEvent(ActionEvent e) {
                        System.out.println("menu clicked..." + e.getActionCommand());
                        if (e.getActionCommand().equals("StopWatch")) {
                            setDisplayState(STOPWATCH_STATE);
                        } else if (e.getActionCommand().equals("Timer")) {
                            setDisplayState(TIMER_STATE);
                        }
                    }
                });
    }

    private void stopWatchStart() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                running = true;
                while (running) {
                    try {
                        Thread.sleep(1000);
                        if (running) {
                            model.incrementSecond();
                            mainFrame.getStopWatchPanelLabel().setText(model.toString());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        // stop button
        mainFrame.getStopWatchButtonPanel().getStopBtn().setEnabled(true);
        // reset button
        mainFrame.getStopWatchButtonPanel().getResetBtn().setEnabled(false);
        // start button
        mainFrame.getStopWatchButtonPanel().getStartBtn().setEnabled(false);

    }

    private void stopWatchStop() {
        running = false;

        // start button
        mainFrame.getStopWatchButtonPanel().getStartBtn().setEnabled(true);
        // stop button
        mainFrame.getStopWatchButtonPanel().getStopBtn().setEnabled(false);
        // reset button
        mainFrame.getStopWatchButtonPanel().getResetBtn().setEnabled(true);
    }

    private void setDisplayState(int newState) {
        this.state = newState;
        modifyViewBasedOnState();
    }

    private void modifyViewBasedOnState() {
        switch (this.state) {
            case SPLASH_STATE:
                System.out.println("modifying view based on splash state");
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "1");
                break;
            case STOPWATCH_STATE:
                System.out.println("modifying view based on stop watch state");
                this.mainFrame.getStopWatchPanelLabel().setText(model.toString());
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "2");
                break;
            case TIMER_STATE:
                System.out.println("modifying view based on timer state");
                this.mainFrame.getTimerPanelLabel().setText(model.toString());
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "3");
                break;
            default:
                break;
        }
    }

}

