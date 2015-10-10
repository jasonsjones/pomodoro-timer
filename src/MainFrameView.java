import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrameView extends JFrame {

    private static final long serialVersionUID = 1L;

    // constants
    public static final int FRAME_WIDTH = 350;
    public static final int FRAME_HEIGHT = 250;

    private StopWatchPanel stopWatchPanel;
    private ButtonPanelView buttonPanel;
    private MainMenuBar mainMenuBar;

    /**
     * Constructs the frame to place other swing components
     */
    public MainFrameView() {
        super("Pomodoro");
        stopWatchPanel = new StopWatchPanel();
        buttonPanel = new ButtonPanelView();
        mainMenuBar = new MainMenuBar();
        setUpUI();
    }

    public ButtonPanelView getButtonPanel() {
        return this.buttonPanel;
    }

    public MainMenuBar getMainMenuBar() {
        return this.mainMenuBar;
    }
    
    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchPanel.getLabel();
    }


    private void setUpUI() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(stopWatchPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setJMenuBar(mainMenuBar);
        this.setVisible(true);
    }
}

