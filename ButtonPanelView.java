import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanelView extends JPanel {

    private static final long serialVersionUID = 1L;

	// constants
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 30;

    // array for buttons--start, stop, & reset
    private JButton[] btn;

    public ButtonPanelView() {

        btn = new JButton[3];

        // start button
        btn[0] = new JButton("Start");
        btn[0].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(btn[0]);

        // stop button
        btn[1] = new JButton("Stop");
        btn[1].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[1].setEnabled(false);
        this.add(btn[1]);

        // reset button
        btn[2] = new JButton("Reset");
        btn[2].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[2].setEnabled(false);
        this.add(btn[2]);

        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }


    public JButton[] getButtons() {
    	return btn;
    }

}
