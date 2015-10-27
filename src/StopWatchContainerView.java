import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

public class StopWatchContainerView extends JPanel{

    private StopWatchButtonPanel buttonPanel;
    private StopWatchPanel stopWatchPanel;

    public StopWatchContainerView() {
        buttonPanel = new StopWatchButtonPanel();
        stopWatchPanel = new StopWatchPanel();
        this.setLayout(new BorderLayout());

        this.add(stopWatchPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public StopWatchButtonPanel getStopWatchButtonPanel() {
        return this.buttonPanel;
    }

    public StopWatchPanel getStopWatchPanel() {
        return this.stopWatchPanel;
    }

    public JLabel getStopWatchPanelLabel() {
        return this.stopWatchPanel.getLabel();
    }
}
