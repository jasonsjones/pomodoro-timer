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
                MainFrameView view = new MainFrameView();
                //StopWatchFrameView view = new StopWatchFrameView();
                //StopWatchModel model = new StopWatchModel();
                //Controller ctrl = new Controller(model, view);
                //ctrl.control();
            }
        });
    	
    }
}

