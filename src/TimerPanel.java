import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    JLabel label;

    public TimerPanel() {
        label = new JLabel();
        setUpUI();
    }

    public JLabel getLabel() {
        return label;
    }

    private void setUpUI() {
        this.setBorder(BorderFactory.createTitledBorder("Timer"));
        label.setFont(new Font("Helvetica", Font.BOLD, 42));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        this.add(label, gc);

        this.setVisible(true);
    }
}
