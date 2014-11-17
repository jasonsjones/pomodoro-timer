import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class ButtonPanel extends JPanel {

    // constants
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 30;

    // timer object
    private Timer timer;

    // label to display time from timer object
    private JLabel label;

    // array for buttons--start, stop, & reset
    private JButton[] btn;

    public ButtonPanel() {

        ButtonHandler buttonHandler = new ButtonHandler();

        btn = new JButton[3];

        // start button
        btn[0] = new JButton("Start");
        btn[0].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[0].addActionListener(buttonHandler);
        this.add(btn[0]);

        // stop button
        btn[1] = new JButton("Stop");
        btn[1].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[1].setEnabled(false);
        btn[1].addActionListener(buttonHandler);
        this.add(btn[1]);

        // reset button
        btn[2] = new JButton("Reset");
        btn[2].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[2].setEnabled(false);
        btn[2].addActionListener(buttonHandler);
        this.add(btn[2]);

        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }


    // private inner class for event handling
    private class ButtonHandler implements ActionListener {

        private volatile boolean running = true;

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == btn[0]) {
                processStartTimer(event);
            }  // event.getSource() == stop button
            else if (event.getSource() == btn[1]) {
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
            // stop button
            btn[1].setEnabled(true);
            // reset button
            btn[2].setEnabled(false);
            // start button
            btn[0].setEnabled(false);
        }


        private void processStopTimer(ActionEvent event) {
            running = false;
            // start button
            btn[0].setEnabled(true);
            // stop button
            btn[1].setEnabled(false);
            // reset button
            btn[2].setEnabled(true);
        }

    } // end of ButtonHandler class
}
