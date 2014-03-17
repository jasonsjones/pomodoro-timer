/**
 * Filename: Timer.java
 *
 * Simple timer class that represents a timer with the notion of an hour,
 * minute, and second in the form of H:MM:SS. Provides some basic functionality
 * of incrementing (by a second) and resetting the timer.
 *
 * @author: Jason Jones (jsjones<at>gmail.com)
 * @version 0.1
 *
 */
public class Timer {

    private int hour;
    private int minute;
    private int second;

    public Timer() {

        this(0, 0, 0);
    }


    public Timer(int h) {

        this(h, 0, 0);
    }


    public Timer(int h, int m) {

        this(h, m, 0);
    }


    public Timer(int h, int m, int s) {

        setTimer(h, m, s);
    }


    public void setTimer(int h, int m, int s) {

        setHour(h);
        setMinute(m);
        setSecond(s);
    }


    public void setHour(int h) {

        this.hour = ( h >= 0 && h < 24 ) ? h : 0;
    }


    public void setMinute(int m) {

        this.minute = (m >= 0 && m < 60 )? m : 0;
    }


    public void setSecond(int s) {

        this.second = (s >= 0 && s < 60 )? s : 0;
    }


    public int getHour(){
        return this.hour;
    }


    public int getMinute(){
        return this.minute;
    }


    public int getSecond(){
        return this.second;
    }


    public int getTotalTimeInSeconds() {
        return getHour() * 60 + getMinute() + ( getSecond() > 30 ? 1 : 0 );

    }


    public void incrementHour() {

        int h = getHour() + 1;

        if (h == 24) setHour(0);
        else setHour(h);
    }


    public void incrementMinute() {

        int m = getMinute() + 1;

        if (m == 60) {
            setMinute(0);
            incrementHour();
        } else
            setMinute(m);
    }


    public void incrementSecond() {

        int s = getSecond() + 1;

        if (s == 60) {
            setSecond(0);
            incrementMinute();
        } else
            setSecond(s);
    }


    public void reset() {
        setTimer(0, 0, 0);
    }


    public String toString() {

        return String.format("%d:%02d:%02d",
                getHour(), getMinute(), getSecond());
    }
}
