import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ButtonPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 30;

    private ClickListener clickListener;

    private JButton startBtn;
    private JButton stopBtn;
    private JButton resetBtn;

    /**
     * Constructs a ButtonPanel and adds three buttons to the button for
     * the 'start', 'stop', and 'reset' button.
     */
    public ButtonPanel() {
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");

        this.setBorder(BorderFactory.createEtchedBorder());

        // set the layout for this panel and place the buttons
        // on the right
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));

        startBtn.addActionListener(this);
        stopBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        add(startBtn);
        add(stopBtn);
        add(resetBtn);
    }

    public void addClickListener(ClickListener listener) {
       this.clickListener = listener;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getStopBtn() {
        return stopBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (clickListener != null) {
            clickListener.onClick(e);
        }
    }
}

