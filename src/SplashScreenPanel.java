import javax.swing.*;
import java.awt.*;

public class SplashScreenPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    public SplashScreenPanel() {
        setUpUI();
    }

    private void setUpUI() {
        JLabel label = new JLabel();
        label.setFont(new Font("Helvetica", Font.BOLD, 32));
        label.setText("Splash screen");

        JLabel copyright = new JLabel();
        copyright.setFont(new Font("Helvetica", Font.ITALIC, 16));
        copyright.setText("copyright 2015 Jason Jones");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        this.add(label, gc);

        gc.gridx = 0;
        gc.gridy++;
        this.add(copyright, gc);

        this.setVisible(true);
    }
}
