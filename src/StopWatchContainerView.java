import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

public class StopWatchContainerView extends JPanel{

    private ButtonPanelView buttonPanel;
    private StopWatchPanel stopWatchPanel;

    public StopWatchContainerView() {
        buttonPanel = new ButtonPanelView();
        stopWatchPanel = new StopWatchPanel();
        this.setLayout(new BorderLayout());

        this.add(stopWatchPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public ButtonPanelView getButtonPanel() {
        return this.buttonPanel;
    }

    public StopWatchPanel getStopWatchPanel() {
        return this.stopWatchPanel;
    }

    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchPanel.getLabel();
    }
}
