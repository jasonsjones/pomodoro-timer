import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 * Basic swing application to display a timer with the basic functionality to
 * start, stop, and reset.  The timer implemented in the application only
 * counts up; it is not a count-down timer.  Maybe a stopwatch would have been
 * a better description.
 *
 * @author Jason Jones jsjones96@gmail.com
 * @version 0.0.1
 */
public class StopWatchFrameView extends JFrame {

    private static final long serialVersionUID = 1L;

    // constants
    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 250;

    ButtonPanelView buttonPanel;

    JLabel label;

    /**
     * Constructs the frame and other GUI components as well as instantiates
     * the timer object and button panel.
     */
    public StopWatchFrameView() {
        super("StopWatch");
        setUpUI();
    }


    public ButtonPanelView getButtonPanel() {
        return buttonPanel;
    }


    public JLabel getLabel() {
        return label;
    }


    private void setUpUI() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createTitledBorder("StopWatch"));

        label = new JLabel();
        label.setFont(new Font("Helvetica", Font.BOLD, 42));
        mainPanel.add(label);

        buttonPanel = new ButtonPanelView();

        setUpMenu();

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    private void setUpMenu() {
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
        JMenuItem modeMenuItem = new JMenuItem("Timer");
        modeMenuItem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		System.out.println("you are switching modes to timer");
        	}
        });
        
        mode.add(modeMenuItem);
        menubar.add(mode);
        this.setJMenuBar(menubar);

    }
}

