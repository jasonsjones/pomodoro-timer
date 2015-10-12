import java.awt.event.ActionEvent;

public class Controller {

    private volatile boolean running = true;

    private TimeModel model;
    private MainFrameView mainFrame;

    public Controller(TimeModel model, MainFrameView view) {
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

        this.mainFrame.getMainMenuBar()
                .addMainMenuListener(new MainMenuListener() {
                    @Override
                    public void emitMenuEvent(ActionEvent e) {
                        System.out.println("menu clicked..." + e.getActionCommand());
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

