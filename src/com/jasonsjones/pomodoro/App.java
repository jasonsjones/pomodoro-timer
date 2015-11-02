package com.jasonsjones.pomodoro;

import java.awt.EventQueue;

public class App {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrameView view = new MainFrameView();
                new Controller(view);
            }
        });
    }
}

