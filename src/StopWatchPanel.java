import javax.swing.BorderFactory;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class StopWatchPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    JLabel label;

    public StopWatchPanel() {
        label = new JLabel();
        setUpUI();
    }

    public JLabel getLabel() {
        return label;
    }


    private void setUpUI() {
        this.setBorder(BorderFactory.createTitledBorder("StopWatch"));

        label.setFont(new Font("Helvetica", Font.BOLD, 42));
        this.add(label);

        this.setVisible(true);
    }
}
