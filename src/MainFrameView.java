import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrameView extends JFrame {

    private static final long serialVersionUID = 1L;

    // constants
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 350;

    private StopWatchPanel stopWatchPanel;
    private ButtonPanelView buttonPanel;

    private int state;
    public static final int STOP_WATCH = 1;
    public static final int TIMER = 2;

    /**
     * Constructs the frame to place other swing components
     */
    public MainFrameView() {
        super("StopWatch/Timer");
        state = STOP_WATCH;
        stopWatchPanel = new StopWatchPanel();
        buttonPanel = new ButtonPanelView();
        setUpUI();
    }

    public ButtonPanelView getButtonPanel() {
        return this.buttonPanel;
    }
    
    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchPanel.getLabel();
    }


    private void setUpUI() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        setUpMenu();

        this.add(stopWatchPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }


    private void setUpMenu() {
        MenuHandler menuHandler = new MenuHandler();
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(eMenuItem);
        menubar.add(file);

        JMenu mode = new JMenu("Mode");
        JMenuItem timerMenuItem = new JMenuItem("Timer");
        timerMenuItem.addActionListener(menuHandler);
        JMenuItem stopWatchMenuItem = new JMenuItem("StopWatch");
        stopWatchMenuItem.addActionListener(menuHandler);

        mode.add(timerMenuItem);
        mode.add(stopWatchMenuItem);
        menubar.add(mode);
        this.setJMenuBar(menubar);

    }

    private void setDisplayState(int newState) {
        state = newState;
    }

    private class MenuHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("you are switching modes to " + e.getActionCommand());

			if (e.getActionCommand() == "Timer") {
				setDisplayState(TIMER);
			} else {
				setDisplayState(STOP_WATCH);
			}

			if (state == STOP_WATCH) {
				stopWatchPanel.setVisible(true);
			} else {
				stopWatchPanel.setVisible(false);
			}

		}

    }

}

