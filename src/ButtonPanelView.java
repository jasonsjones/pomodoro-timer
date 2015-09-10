import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanelView extends JPanel {

    // consants
    private static final int START = 0;
    private static final int STOP = 1;
    private static final int RESET = 2;

    private static final long serialVersionUID = 1L;

    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 30;

    // array for buttons--start, stop, & reset
    private JButton[] btn;

    /**
     * Constructs a ButtonPanel and adds three buttons to the button for
     * the 'start', 'stop', and 'reset' button.
     */
    public ButtonPanelView() {
        // instantiate an array of 3 JButtons
        btn = new JButton[3];

        // start button
        btn[START] = new JButton("Start");
        btn[START].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(btn[START]);

        // stop button
        btn[STOP] = new JButton("Stop");
        btn[STOP].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[STOP].setEnabled(false);
        this.add(btn[STOP]);

        // reset button
        btn[RESET] = new JButton("Reset");
        btn[RESET].setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btn[RESET].setEnabled(false);
        this.add(btn[RESET]);

        // set the layout for this panel and place the buttons
        // on the right
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }


    /**
     * Returns the array of buttons added to the panel.  This is needed so
     * the action listener can get access to the buttons to know when they
     * are clicked.
     *
     * @return the array of buttons
     */
    public JButton[] getButtons() {
        return btn;
    }
}

