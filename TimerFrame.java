import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.EventQueue;

public class TimerFrame extends JFrame {

    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 150;
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 30;

    private JLabel label;
    private JButton startTimer;
    private JButton stopTimer;

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

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Timer"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        label = new JLabel(timer.toString());
        label.setFont(new Font("Helvetica", Font.BOLD, 42));

        startTimer = new JButton("Start");
        startTimer.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        startTimer.addActionListener(buttonHandler);

        stopTimer = new JButton("Stop");
        stopTimer.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        stopTimer.setEnabled(false);
        stopTimer.addActionListener(buttonHandler);

        panel.add(label);
        buttonPanel.add(startTimer);
        buttonPanel.add(stopTimer);

        this.add(panel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {

        private volatile boolean running = true;

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == startTimer) {
                processStartTimer(event);
            }
            else { // event.getSource() == stopTimer
                processStopTimer(event);
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
                            timer.incrementSecond();
                            label.setText(timer.toString());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            t.start();
            stopTimer.setEnabled(true);
            startTimer.setEnabled(false);
        }


        private void processStopTimer(ActionEvent event) {
            running = false;
            startTimer.setEnabled(true);
            stopTimer.setEnabled(false);
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
