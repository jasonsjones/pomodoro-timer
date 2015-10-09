import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * @author Jason Jones (jsjone96@gmail.com)
 *
 */
public class Controller {

    private volatile boolean running = true;

    private StopWatchModel model;
    private MainFrameView mainFrame;

    public Controller(StopWatchModel model, MainFrameView view) {
        this.model = model;
        this.mainFrame = view;
        this.mainFrame.getStopWatchPanelLabel().setText(this.model.toString());

        setUpListeners();
    }

    private void setUpListeners() {
        this.mainFrame.getButtonPanel()
                .addClickListener(new ClickListener() {

                    @Override
                    public void onClick(ActionEvent e) {

                        if (e.getActionCommand().equals("Start")) {
                            processStart();
                        } else if (e.getActionCommand().equals("Stop")) {
                            processStop();
                        } else {
                            model.reset();
                            mainFrame.getStopWatchPanelLabel().setText(model.toString());
                        }
                    }
                });
    }

    private void processStart() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                running = true;
                while (running) {
                    try {
                        Thread.sleep(1000);
                        if (running) {
                            model.incrementSecond();
                            mainFrame.getStopWatchPanelLabel().setText(model.toString());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        // stop button
        mainFrame.getButtonPanel().getStopBtn().setEnabled(true);
        // reset button
        mainFrame.getButtonPanel().getResetBtn().setEnabled(false);
        // start button
        mainFrame.getButtonPanel().getStartBtn().setEnabled(false);

    }


    private void processStop() {
        running = false;

        // start button
        mainFrame.getButtonPanel().getStartBtn().setEnabled(true);
        // stop button
        mainFrame.getButtonPanel().getStopBtn().setEnabled(false);
        // reset button
        mainFrame.getButtonPanel().getResetBtn().setEnabled(true);
    }
}

