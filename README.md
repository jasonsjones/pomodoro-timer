# Pomodoro Timer Application

Simple pomodoro timer application written in Java and built with Java Swing
components.

This application provides the basic functionality of a countdown timer and
stopwatch.  The timer is set to 30:00 by default; however, provides controls to
increment or decrement the time by one minute intervals.  The timer and
stopwatch can run independently of each other, meaning they can be started and
stopped at different times, as well as run simultaneously.  Each runs in its
own thread.

The goal of this application is to focus on best practices, particularly the
single responsibility principle as well as object-oriented design.  To achieve
this goal, this project implements the Model-View-Controller (MVC) design
pattern.
