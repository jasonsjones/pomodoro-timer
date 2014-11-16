import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.EventQueue;

// TODO: add javadoc comments
public class TimerFrame extends JFrame {

    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 150;
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 30;

    //private JPanel mainPanel;
    //private JPanel buttonPanel;

    private JLabel label;
    private JButton startTimerButton;
    private JButton stopTimerButton;
    private JButton resetButton;

    private ButtonHandler buttonHandler;
    private Timer timer;

    public TimerFrame() {

        super("Timer");
        timer = new Timer();
        buttonHandler = new ButtonHandler();
        setUpUI();
    }

    private void setUpUI() {

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createTitledBorder("Timer"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        label = new JLabel(timer.toString());
        label.setFont(new Font("Helvetica", Font.BOLD, 42));
        mainPanel.add(label);

        setUpButtons(buttonPanel);
        setUpMenu();

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void setUpButtons(JPanel buttonPanel) {

        // start button
        startTimerButton = new JButton("Start");
        startTimerButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        startTimerButton.addActionListener(buttonHandler);
        buttonPanel.add(startTimerButton);

        // stop button
        stopTimerButton = new JButton("Stop");
        stopTimerButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        stopTimerButton.setEnabled(false);
        stopTimerButton.addActionListener(buttonHandler);
        buttonPanel.add(stopTimerButton);

        // reset button
        resetButton = new JButton("Reset");
        resetButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        resetButton.setEnabled(false);
        resetButton.addActionListener(buttonHandler);
        buttonPanel.add(resetButton);
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

        file.add (eMenuItem);
        menubar.add(file);
        this.setJMenuBar(menubar);

    }

    private class ButtonHandler implements ActionListener {

        private volatile boolean running = true;

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == startTimerButton) {
                processStartTimer(event);
            }  // event.getSource() == stopTimerButton
            else if (event.getSource() == stopTimerButton) {
                processStopTimer(event);
            } else {
                timer.reset();
                label.setText(timer.toString());
            }
        } // end of actionPerformed


        private void processStartTimer(ActionEvent event) {

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    running = true;
                    while (running) {
                        try {
                            Thread.sleep(1000);
                            if (running) {
                                timer.incrementSecond();
                                label.setText(timer.toString());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            t.start();
            stopTimerButton.setEnabled(true);
            resetButton.setEnabled(false);
            startTimerButton.setEnabled(false);
        }


        private void processStopTimer(ActionEvent event) {
            running = false;
            startTimerButton.setEnabled(true);
            stopTimerButton.setEnabled(false);
            resetButton.setEnabled(true);
        }


    } // end of ButtonHandler class


    public static void main (String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimerFrame tf = new TimerFrame();
            }

        });
    }
}
