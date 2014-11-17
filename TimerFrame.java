import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.EventQueue;

/**
 * Basic swing application to display a timer with the basic functionalty to
 * start, stop, and reset.  The timer implemented in the application only
 * counts up; it is not a count-down timer.  Maybe a stopwatch would have been
 * a better description.
 *
 * @author Jason Jones jsjones96<at>gmail.com
 * @version 0.0.1
 */
public class TimerFrame extends JFrame {

    // constants
    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 150;
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 30;

    // timer object
    private Timer timer;


    /**
     * Constructs the frame and other GUI components as well as instantiates
     * the timer object and button event handler.
     */
    public TimerFrame() {

        super("Timer");
        timer = new Timer();
        setUpUI();
    }

    private void setUpUI() {

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createTitledBorder("Timer"));

        JLabel label = new JLabel(timer.toString());
        label.setFont(new Font("Helvetica", Font.BOLD, 42));
        mainPanel.add(label);

        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setTimer(timer);
        buttonPanel.setLabel(label);

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
        this.setJMenuBar(menubar);

    }

    public static void main (String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimerFrame tf = new TimerFrame();
            }

        });
    }
}
