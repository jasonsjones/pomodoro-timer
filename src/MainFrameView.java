import java.awt.*;

import javax.swing.*;

public class MainFrameView extends JFrame {

    private static final long serialVersionUID = 1L;

    // constants
    public static final int FRAME_WIDTH = 350;
    public static final int FRAME_HEIGHT = 250;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StopWatchContainerView stopWatchContainerView;
    private SplashScreenPanel splashScreenPanel;
    private MainMenuBar mainMenuBar;

    /**
     * Constructs the frame to place other swing components
     */
    public MainFrameView() {
        super("Pomodoro");
        stopWatchContainerView = new StopWatchContainerView();
        mainMenuBar = new MainMenuBar();
        splashScreenPanel = new SplashScreenPanel();
        setUpUI();
    }

    public ButtonPanel getStopWatchButtonPanel() {
        return this.stopWatchContainerView.getStopWatchButtonPanel();
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

    public StopWatchContainerView getStopWatchContainerView() {
        return this.stopWatchContainerView;
    }

    public StopWatchPanel getStopWatchPanel() {
        return this.stopWatchContainerView.getStopWatchPanel();
    }

    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchContainerView.getStopWatchPanelLabel();
    }


    private void setUpUI() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();

        mainPanel.setLayout(cardLayout);
        mainPanel.add(splashScreenPanel, "1");
        mainPanel.add(stopWatchContainerView, "2");
        cardLayout.show(mainPanel, "1");

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(mainMenuBar);
        this.add(mainPanel);
        this.setVisible(true);
    }
}

