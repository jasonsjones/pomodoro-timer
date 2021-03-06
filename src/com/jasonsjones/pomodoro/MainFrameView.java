package com.jasonsjones.pomodoro;

import java.awt.*;

import javax.swing.*;

public class MainFrameView extends JFrame {

    private static final long serialVersionUID = 1L;

    // constants
    public static final int FRAME_WIDTH = 350;
    public static final int FRAME_HEIGHT = 250;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ContainerView stopWatchContainerView;
    private ContainerView timerContainerView;
    private SplashScreenPanel splashScreenPanel;
    private MainMenuBar mainMenuBar;

    /**
     * Constructs the frame to place other swing components
     */
    public MainFrameView() {
        super("Pomodoro");
        stopWatchContainerView = new StopWatchContainerView();
        timerContainerView = new TimerContainerView();
        mainMenuBar = new MainMenuBar();
        splashScreenPanel = new SplashScreenPanel();
        setUpUI();
    }

    public CardLayout getCardLayout() {
        return this.cardLayout;
    }

    public MainMenuBar getMainMenuBar() {
        return this.mainMenuBar;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public SplashScreenPanel getSplashScreenPanel() {
        return this.splashScreenPanel;
    }

    public ButtonPanel getStopWatchButtonPanel() {
        return this.stopWatchContainerView.getButtonPanel();
    }

    public ButtonPanel getTimerButtonPanel() {
        return this.timerContainerView.getButtonPanel();
    }

    public ContainerView getStopWatchContainerView() {
        return this.stopWatchContainerView;
    }

    public ContainerView getTimerContainerView() {
        return this.timerContainerView;
    }

    public TimeDisplayPanel getStopWatchPanel() {
        return this.stopWatchContainerView.getDisplayPanel();
    }

    public TimeDisplayPanel getTimerPanel() {
        return this.timerContainerView.getDisplayPanel();
    }

    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchContainerView.getDisplayPanelLabel();
    }

    public JLabel getTimerPanelLabel() {
        return this.timerContainerView.getDisplayPanelLabel();
    }

    private void setUpUI() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();

        mainPanel.setLayout(cardLayout);
        mainPanel.add(splashScreenPanel, "1");
        mainPanel.add(stopWatchContainerView, "2");
        mainPanel.add(timerContainerView, "3");
        cardLayout.show(mainPanel, "1");

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(mainMenuBar);
        this.add(mainPanel);
        this.setVisible(true);
    }
}
