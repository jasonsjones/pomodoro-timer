package com.jasonsjones.pomodoro;

import java.awt.event.ActionEvent;

public class Controller {

    public static final int SPLASH_STATE = 0;
    public static final int STOPWATCH_STATE = 1;
    public static final int TIMER_STATE = 2;

    private volatile boolean isStopWatchRunning = true;
    private volatile boolean isTimerRunning = true;

    private TimeModel stopWatchModel;
    private TimeModel timerModel;
    private MainFrameView mainFrame;
    private int state;

    public Controller(MainFrameView view) {
        this.stopWatchModel = new TimeModel();
        this.timerModel = new TimeModel(30, 0);
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
                            stopWatchModel.reset();
                            mainFrame.getStopWatchPanelLabel().setText(stopWatchModel.toString());
                        }
                    }
                });

        this.mainFrame.getTimerButtonPanel()
                .addClickListener(new ClickListener() {

                    @Override
                    public void onClick(ActionEvent e) {
                        if (e.getActionCommand().equals("Start")) {
                            timerStart();
                        } else if (e.getActionCommand().equals("Stop")) {
                            timerStop();
                        } else {
                            timerModel.setTimer(0, 30, 0);
                            mainFrame.getTimerPanelLabel().setText(timerModel.toString());
                        }
                    }
                });

        this.mainFrame.getMainMenuBar()
                .addMainMenuListener(new MainMenuListener() {
                    @Override
                    public void emitMenuEvent(ActionEvent e) {
                        if (e.getActionCommand().equals("StopWatch")) {
                            setDisplayState(STOPWATCH_STATE);
                        } else if (e.getActionCommand().equals("Timer")) {
                            setDisplayState(TIMER_STATE);
                        } else if (e.getActionCommand().equals("Splash Screen")) {
                            setDisplayState(SPLASH_STATE);
                        }
                    }
                });

        TimerContainerView tcv = (TimerContainerView) this.mainFrame.getTimerContainerView();
        tcv.getAdjustTimerButtonPanel().addClickListener(new ClickListener() {
            @Override
            public void onClick(ActionEvent e) {
                if (e.getActionCommand().equals("+ min")) {
                    timerModel.setTimer(timerModel.getTimeInSeconds() + 60);
                    mainFrame.getTimerPanelLabel().setText(timerModel.toString());
                } else if (e.getActionCommand().equals("- min")) {
                    timerModel.setTimer(timerModel.getTimeInSeconds() - 60);
                    mainFrame.getTimerPanelLabel().setText(timerModel.toString());
                }
            }
        });
    }

    private void stopWatchStart() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                isStopWatchRunning = true;
                while (isStopWatchRunning) {
                    try {
                        Thread.sleep(1000);
                        if (isStopWatchRunning) {
                            stopWatchModel.incrementSecond();
                            mainFrame.getStopWatchPanelLabel().setText(stopWatchModel.toString());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        setButtonVisibilityOnStart(mainFrame.getStopWatchButtonPanel());
    }

    private void timerStart() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                isTimerRunning = true;
                while (isTimerRunning) {
                    try {
                        Thread.sleep(1000);
                        if (isTimerRunning) {
                            timerModel.decrementSecond();
                            mainFrame.getTimerPanelLabel().setText(timerModel.toString());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        setButtonVisibilityOnStart(mainFrame.getTimerButtonPanel());
    }

    private void stopWatchStop() {
        isStopWatchRunning = false;
        setButtonVisibilityOnStop(mainFrame.getStopWatchButtonPanel());
    }

    private void timerStop() {
        isTimerRunning = false;
        setButtonVisibilityOnStop(mainFrame.getTimerButtonPanel());
    }

    private void setButtonVisibilityOnStart(ButtonPanel bp) {
        bp.getStopBtn().setEnabled(true);
        bp.getResetBtn().setEnabled(false);
        bp.getStartBtn().setEnabled(false);
    }

    private void setButtonVisibilityOnStop(ButtonPanel bp) {
        bp.getStopBtn().setEnabled(false);
        bp.getResetBtn().setEnabled(true);
        bp.getStartBtn().setEnabled(true);

    }

    private void setDisplayState(int newState) {
        this.state = newState;
        modifyViewBasedOnState();
    }

    private void modifyViewBasedOnState() {
        switch (this.state) {
            case SPLASH_STATE:
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "1");
                break;
            case STOPWATCH_STATE:
                this.mainFrame.getStopWatchPanelLabel().setText(stopWatchModel.toString());
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "2");
                break;
            case TIMER_STATE:
                this.mainFrame.getTimerPanelLabel().setText(timerModel.toString());
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "3");
                break;
            default:
                break;
        }
    }

}

