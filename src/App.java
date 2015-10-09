import java.awt.EventQueue;

public class App {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrameView view = new MainFrameView();
                StopWatchModel model = new StopWatchModel();
                new Controller(model, view);
            }
        });
    }
}

