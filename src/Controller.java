import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * @author Jason Jones (jsjone96@gmail.com)
 *
 */
public class Controller {

    // constants
    private static final int START = 0;
    private static final int STOP = 1;
    private static final int RESET = 2;

    private StopWatchModel model;
    private StopWatchFrameView view;
    private ActionListener actionListener;
    private JButton[] btn;


    public Controller(StopWatchModel model, StopWatchFrameView view) {
        this.model = model;
        this.view = view;
        this.btn = view.getButtonPanel().getButtons();
        this.actionListener = new ButtonHandler();
    }


    public void control() {

        for (int i = 0; i < btn.length; i++) {
            btn[i].addActionListener(actionListener);
        }

        view.getLabel().setText(model.toString());
    }


    /**
     * private inner class for event handling
     *
     *
     */
    private class ButtonHandler implements ActionListener {

        private volatile boolean running = true;

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == btn[START]) {
                processStartTimer(event);
            }  // event.getSource() == stop button
            else if (event.getSource() == btn[STOP]) {
                processStopTimer(event);
            } else {
                model.reset();
                view.getLabel().setText(model.toString());
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
                                model.incrementSecond();
                                view.getLabel().setText(model.toString());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            t.start();
            // stop button
            btn[STOP].setEnabled(true);
            // reset button
            btn[RESET].setEnabled(false);
            // start button
            btn[START].setEnabled(false);
        }


        private void processStopTimer(ActionEvent event) {
            running = false;
            // start button
            btn[START].setEnabled(true);
            // stop button
            btn[STOP].setEnabled(false);
            // reset button
            btn[RESET].setEnabled(true);
        }

    } // end of ButtonHandler class
}

