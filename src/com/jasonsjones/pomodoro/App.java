package com.jasonsjones.pomodoro;

import java.awt.EventQueue;

public class App {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrameView view = new MainFrameView();
                TimeModel model = new TimeModel();
                new Controller(model, view);
            }
        });
    }
}

