import java.awt.EventQueue;



/**
 * @author Jason Jones (jsjones96@gmail.com)
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimerFrameView view = new TimerFrameView();
                TimerModel model = new TimerModel();
                Controller ctrl = new Controller(model, view);
                ctrl.control();
            }
        });
	}
}
